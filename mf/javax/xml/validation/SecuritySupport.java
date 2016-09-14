package mf.javax.xml.validation;

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

    /* renamed from: mf.javax.xml.validation.SecuritySupport.1 */
    class C10041 implements PrivilegedAction {
        C10041() {
        }

        public Object run() {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                return ClassLoader.getSystemClassLoader();
            }
            return cl;
        }
    }

    /* renamed from: mf.javax.xml.validation.SecuritySupport.2 */
    class C10052 implements PrivilegedAction {
        private final /* synthetic */ String val$propName;

        C10052(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: mf.javax.xml.validation.SecuritySupport.3 */
    class C10063 implements PrivilegedExceptionAction {
        private final /* synthetic */ File val$file;

        C10063(File file) {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: mf.javax.xml.validation.SecuritySupport.4 */
    class C10074 implements PrivilegedExceptionAction {
        private final /* synthetic */ URL val$url;

        C10074(URL url) {
            this.val$url = url;
        }

        public Object run() throws IOException {
            return this.val$url.openStream();
        }
    }

    /* renamed from: mf.javax.xml.validation.SecuritySupport.5 */
    class C10085 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10085(ClassLoader classLoader, String str) {
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

    /* renamed from: mf.javax.xml.validation.SecuritySupport.6 */
    class C10096 implements PrivilegedExceptionAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10096(ClassLoader classLoader, String str) {
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

    /* renamed from: mf.javax.xml.validation.SecuritySupport.7 */
    class C10107 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C10107(ClassLoader classLoader, String str) {
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

    /* renamed from: mf.javax.xml.validation.SecuritySupport.8 */
    class C10118 implements PrivilegedAction {
        private final /* synthetic */ File val$f;

        C10118(File file) {
            this.val$f = file;
        }

        public Object run() {
            return new Boolean(this.val$f.exists());
        }
    }

    SecuritySupport() {
    }

    ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C10041());
    }

    String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C10052(propName));
    }

    FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C10063(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    InputStream getURLInputStream(URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new C10074(url));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    URL getResourceAsURL(ClassLoader cl, String name) {
        return (URL) AccessController.doPrivileged(new C10085(cl, name));
    }

    Enumeration getResources(ClassLoader cl, String name) throws IOException {
        try {
            return (Enumeration) AccessController.doPrivileged(new C10096(cl, name));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C10107(cl, name));
    }

    boolean doesFileExist(File f) {
        return ((Boolean) AccessController.doPrivileged(new C10118(f))).booleanValue();
    }
}
