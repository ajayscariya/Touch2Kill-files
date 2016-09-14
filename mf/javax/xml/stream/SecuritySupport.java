package mf.javax.xml.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

class SecuritySupport {

    /* renamed from: mf.javax.xml.stream.SecuritySupport.1 */
    class C09931 implements PrivilegedAction {
        C09931() {
        }

        public Object run() {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                return ClassLoader.getSystemClassLoader();
            }
            return cl;
        }
    }

    /* renamed from: mf.javax.xml.stream.SecuritySupport.2 */
    class C09942 implements PrivilegedAction {
        private final /* synthetic */ String val$propName;

        C09942(String str) {
            this.val$propName = str;
        }

        public Object run() {
            return System.getProperty(this.val$propName);
        }
    }

    /* renamed from: mf.javax.xml.stream.SecuritySupport.3 */
    class C09953 implements PrivilegedExceptionAction {
        private final /* synthetic */ File val$file;

        C09953(File file) {
            this.val$file = file;
        }

        public Object run() throws FileNotFoundException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: mf.javax.xml.stream.SecuritySupport.4 */
    class C09964 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C09964(ClassLoader classLoader, String str) {
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

    /* renamed from: mf.javax.xml.stream.SecuritySupport.5 */
    class C09975 implements PrivilegedAction {
        private final /* synthetic */ File val$f;

        C09975(File file) {
            this.val$f = file;
        }

        public Object run() {
            return new Boolean(this.val$f.exists());
        }
    }

    SecuritySupport() {
    }

    ClassLoader getContextClassLoader() throws SecurityException {
        return (ClassLoader) AccessController.doPrivileged(new C09931());
    }

    String getSystemProperty(String propName) {
        return (String) AccessController.doPrivileged(new C09942(propName));
    }

    FileInputStream getFileInputStream(File file) throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new C09953(file));
        } catch (PrivilegedActionException e) {
            throw ((FileNotFoundException) e.getException());
        }
    }

    InputStream getResourceAsStream(ClassLoader cl, String name) {
        return (InputStream) AccessController.doPrivileged(new C09964(cl, name));
    }

    boolean doesFileExist(File f) {
        return ((Boolean) AccessController.doPrivileged(new C09975(f))).booleanValue();
    }
}
