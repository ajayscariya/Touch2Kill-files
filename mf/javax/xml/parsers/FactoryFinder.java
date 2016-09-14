package mf.javax.xml.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

class FactoryFinder {
    static Properties cacheProps;
    private static boolean debug;
    static volatile boolean firstTime;
    static SecuritySupport ss;

    static class ConfigurationError extends Error {
        private Exception exception;

        ConfigurationError(String msg, Exception x) {
            super(msg);
            this.exception = x;
        }

        Exception getException() {
            return this.exception;
        }

        public Throwable getCause() {
            return this.exception;
        }
    }

    FactoryFinder() {
    }

    static {
        boolean z = true;
        debug = false;
        cacheProps = new Properties();
        firstTime = true;
        ss = new SecuritySupport();
        try {
            String val = ss.getSystemProperty("jaxp.debug");
            if (val == null || SchemaSymbols.ATTVAL_FALSE.equals(val)) {
                z = false;
            }
            debug = z;
        } catch (SecurityException e) {
            debug = false;
        }
    }

    private static void dPrint(String msg) {
        if (debug) {
            System.err.println("JAXP: " + msg);
        }
    }

    private static Class getProviderClass(String className, ClassLoader cl, boolean doFallback, boolean useBSClsLoader) throws ClassNotFoundException {
        if (cl != null) {
            return cl.loadClass(className);
        }
        if (useBSClsLoader) {
            try {
                return Class.forName(className, true, FactoryFinder.class.getClassLoader());
            } catch (ClassNotFoundException e1) {
                if (doFallback) {
                    return Class.forName(className, true, FactoryFinder.class.getClassLoader());
                }
                throw e1;
            }
        }
        cl = ss.getContextClassLoader();
        if (cl != null) {
            return cl.loadClass(className);
        }
        throw new ClassNotFoundException();
    }

    static Object newInstance(String className, ClassLoader cl, boolean doFallback) throws ConfigurationError {
        return newInstance(className, cl, doFallback, false);
    }

    static Object newInstance(String className, ClassLoader cl, boolean doFallback, boolean useBSClsLoader) throws ConfigurationError {
        try {
            Class providerClass = getProviderClass(className, cl, doFallback, useBSClsLoader);
            Object instance = providerClass.newInstance();
            if (debug) {
                dPrint("created new instance of " + providerClass + " using ClassLoader: " + cl);
            }
            return instance;
        } catch (ClassNotFoundException x) {
            throw new ConfigurationError("Provider " + className + " not found", x);
        } catch (Exception x2) {
            throw new ConfigurationError("Provider " + className + " could not be instantiated: " + x2, x2);
        }
    }

    static Object find(String factoryId, String fallbackClassName) throws ConfigurationError {
        dPrint("find factoryId =" + factoryId);
        try {
            String systemProp = ss.getSystemProperty(factoryId);
            if (systemProp != null) {
                dPrint("found system property, value=" + systemProp);
                return newInstance(systemProp, null, true);
            }
        } catch (SecurityException se) {
            if (debug) {
                se.printStackTrace();
            }
        }
        try {
            if (firstTime) {
                synchronized (cacheProps) {
                    if (firstTime) {
                        File f = new File(new StringBuilder(String.valueOf(ss.getSystemProperty("java.home"))).append(File.separator).append("lib").append(File.separator).append("jaxp.properties").toString());
                        firstTime = false;
                        if (ss.doesFileExist(f)) {
                            dPrint("Read properties file " + f);
                            cacheProps.load(ss.getFileInputStream(f));
                        }
                    }
                }
            }
            String factoryClassName = cacheProps.getProperty(factoryId);
            if (factoryClassName != null) {
                dPrint("found in $java.home/jaxp.properties, value=" + factoryClassName);
                return newInstance(factoryClassName, null, true);
            }
        } catch (Exception ex) {
            if (debug) {
                ex.printStackTrace();
            }
        }
        Object provider = findJarServiceProvider(factoryId);
        if (provider != null) {
            return provider;
        }
        if (fallbackClassName == null) {
            throw new ConfigurationError("Provider for " + factoryId + " cannot be found", null);
        }
        dPrint("loaded from fallback value: " + fallbackClassName);
        return newInstance(fallbackClassName, null, true);
    }

    private static Object findJarServiceProvider(String factoryId) throws ConfigurationError {
        InputStream is;
        String serviceId = "META-INF/services/" + factoryId;
        ClassLoader cl = ss.getContextClassLoader();
        boolean useBSClsLoader = false;
        if (cl != null) {
            is = ss.getResourceAsStream(cl, serviceId);
            if (is == null) {
                cl = FactoryFinder.class.getClassLoader();
                is = ss.getResourceAsStream(cl, serviceId);
                useBSClsLoader = true;
            }
        } else {
            cl = FactoryFinder.class.getClassLoader();
            is = ss.getResourceAsStream(cl, serviceId);
            useBSClsLoader = true;
        }
        if (is == null) {
            return null;
        }
        BufferedReader rd;
        if (debug) {
            dPrint("found jar resource=" + serviceId + " using ClassLoader: " + cl);
        }
        try {
            rd = new BufferedReader(new InputStreamReader(is, Defaults.Encoding));
        } catch (UnsupportedEncodingException e) {
            rd = new BufferedReader(new InputStreamReader(is));
        }
        try {
            String factoryClassName = rd.readLine();
            rd.close();
            if (factoryClassName == null || XMLConstants.NULL_NS_URI.equals(factoryClassName)) {
                return null;
            }
            dPrint("found in resource, value=" + factoryClassName);
            return newInstance(factoryClassName, cl, false, useBSClsLoader);
        } catch (IOException e2) {
            return null;
        }
    }
}
