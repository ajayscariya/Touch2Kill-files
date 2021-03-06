package mf.javax.xml.namespace;

import com.silvermob.sdk.BuildConfig;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import mf.javax.xml.XMLConstants;

public class QName implements Serializable {
    private static final long compatibleSerialVersionUID = 4418622981026545151L;
    private static final long defaultSerialVersionUID = -9120448754896609940L;
    private static final long serialVersionUID;
    private static boolean useDefaultSerialVersionUID;
    private final String localPart;
    private final String namespaceURI;
    private final String prefix;

    /* renamed from: mf.javax.xml.namespace.QName.1 */
    class C09871 implements PrivilegedAction {
        C09871() {
        }

        public Object run() {
            return System.getProperty("com.sun.xml.namespace.QName.useCompatibleSerialVersionUID");
        }
    }

    static {
        useDefaultSerialVersionUID = true;
        try {
            String valueUseCompatibleSerialVersionUID = (String) AccessController.doPrivileged(new C09871());
            boolean z = valueUseCompatibleSerialVersionUID == null || !valueUseCompatibleSerialVersionUID.equals(BuildConfig.VERSION_NAME);
            useDefaultSerialVersionUID = z;
        } catch (Exception e) {
            useDefaultSerialVersionUID = true;
        }
        if (useDefaultSerialVersionUID) {
            serialVersionUID = defaultSerialVersionUID;
        } else {
            serialVersionUID = compatibleSerialVersionUID;
        }
    }

    public QName(String namespaceURI, String localPart) {
        this(namespaceURI, localPart, XMLConstants.NULL_NS_URI);
    }

    public QName(String namespaceURI, String localPart, String prefix) {
        if (namespaceURI == null) {
            this.namespaceURI = XMLConstants.NULL_NS_URI;
        } else {
            this.namespaceURI = namespaceURI;
        }
        if (localPart == null) {
            throw new IllegalArgumentException("local part cannot be \"null\" when creating a QName");
        }
        this.localPart = localPart;
        if (prefix == null) {
            throw new IllegalArgumentException("prefix cannot be \"null\" when creating a QName");
        }
        this.prefix = prefix;
    }

    public QName(String localPart) {
        this(XMLConstants.NULL_NS_URI, localPart, XMLConstants.NULL_NS_URI);
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public final boolean equals(Object objectToTest) {
        if (objectToTest == this) {
            return true;
        }
        if (objectToTest == null || !(objectToTest instanceof QName)) {
            return false;
        }
        QName qName = (QName) objectToTest;
        if (this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public String toString() {
        if (this.namespaceURI.equals(XMLConstants.NULL_NS_URI)) {
            return this.localPart;
        }
        return "{" + this.namespaceURI + "}" + this.localPart;
    }

    public static QName valueOf(String qNameAsString) {
        if (qNameAsString == null) {
            throw new IllegalArgumentException("cannot create QName from \"null\" or \"\" String");
        } else if (qNameAsString.length() == 0) {
            return new QName(XMLConstants.NULL_NS_URI, qNameAsString, XMLConstants.NULL_NS_URI);
        } else {
            if (qNameAsString.charAt(0) != '{') {
                return new QName(XMLConstants.NULL_NS_URI, qNameAsString, XMLConstants.NULL_NS_URI);
            }
            if (qNameAsString.startsWith("{}")) {
                throw new IllegalArgumentException("Namespace URI .equals(XMLConstants.NULL_NS_URI), .equals(\"\"), only the local part, \"" + qNameAsString.substring(XMLConstants.NULL_NS_URI.length() + 2) + "\", " + "should be provided.");
            }
            int endOfNamespaceURI = qNameAsString.indexOf(125);
            if (endOfNamespaceURI != -1) {
                return new QName(qNameAsString.substring(1, endOfNamespaceURI), qNameAsString.substring(endOfNamespaceURI + 1), XMLConstants.NULL_NS_URI);
            }
            throw new IllegalArgumentException("cannot create QName from \"" + qNameAsString + "\", missing closing \"}\"");
        }
    }
}
