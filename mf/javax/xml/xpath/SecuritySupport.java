package mf.javax.xml.xpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

class SecuritySupport {

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.1 */
    class C10121 implements PrivilegedAction {
        C10121() {
        }

        public Object run() {
            ClassLoader cl = null;
            try {
                cl = Thread.currentThread().getContextClassLoader();
            } catch (SecurityException e) {
            }
            return cl;
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.2 */
    class C10132 implements PrivilegedAction {
        private final /* synthetic */ String val$propName;

        C10132(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.3 */
    class C10143 implements PrivilegedExceptionAction {
        private final /* synthetic */ File val$file;

        C10143(File file) {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.4 */
    class C10154 implements PrivilegedExceptionAction {
        private final /* synthetic */ URL val$url;

        C10154(URL url) {
            this.val$url = url;
        }

        public Object run() throws IOException {
            return this.val$url.openStream();
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.5 */
    class C10165 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10165(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() {
            if (this.val$cl == null) {
                return Object.class.getResource(this.val$name);
            }
            return this.val$cl.getResource(this.val$name);
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.6 */
    class C10176 implements PrivilegedExceptionAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10176(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() throws IOException {
            if (this.val$cl == null) {
                return ClassLoader.getSystemResources(this.val$name);
            }
            return this.val$cl.getResources(this.val$name);
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.7 */
    class C10187 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10187(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() {
            if (this.val$cl == null) {
                return Object.class.getResourceAsStream(this.val$name);
            }
            return this.val$cl.getResourceAsStream(this.val$name);
        }
    }

    /* renamed from: mf.javax.xml.xpath.SecuritySupport.8 */
    class C10198 implements PrivilegedAction {
        private final /* synthetic */ File val$f;

        C10198(File file) {
            this.val$f = file;
        }

        public Object run() {
            return new Boolean(this.val$f.exists());
        }
    }

    SecuritySupport() {
    }

    ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C10121());
    }

    String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C10132(propName));
    }

    FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C10143(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    InputStream getURLInputStream(URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new C10154(url));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    URL getResourceAsURL(ClassLoader cl, String name) {
        return (URL) AccessController.doPrivileged(new C10165(cl, name));
    }

    Enumeration getResources(ClassLoader cl, String name) throws IOException {
        try {
            return (Enumeration) AccessController.doPrivileged(new C10176(cl, name));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C10187(cl, name));
    }

    boolean doesFileExist(File f) {
        return ((Boolean) AccessController.doPrivileged(new C10198(f))).booleanValue();
    }
}
