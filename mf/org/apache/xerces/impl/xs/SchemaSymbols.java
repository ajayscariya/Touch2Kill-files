package mf.org.apache.xerces.impl.xs;

import mf.javax.xml.XMLConstants;
import mf.javax.xml.transform.OutputKeys;
import mf.org.apache.xerces.xni.grammars.XMLGrammarDescription;

public final class SchemaSymbols {
    public static final String ATTVAL_ANYSIMPLETYPE = "anySimpleType";
    public static final String ATTVAL_ANYTYPE = "anyType";
    public static final String ATTVAL_ANYURI = "anyURI";
    public static final String ATTVAL_BASE64BINARY = "base64Binary";
    public static final String ATTVAL_BOOLEAN = "boolean";
    public static final String ATTVAL_BYTE = "byte";
    public static final String ATTVAL_COLLAPSE = "collapse";
    public static final String ATTVAL_DATE = "date";
    public static final String ATTVAL_DATETIME = "dateTime";
    public static final String ATTVAL_DAY = "gDay";
    public static final String ATTVAL_DECIMAL = "decimal";
    public static final String ATTVAL_DOUBLE = "double";
    public static final String ATTVAL_DURATION = "duration";
    public static final String ATTVAL_ENTITIES = "ENTITIES";
    public static final String ATTVAL_ENTITY = "ENTITY";
    public static final String ATTVAL_EXTENSION = "extension";
    public static final String ATTVAL_FALSE = "false";
    public static final String ATTVAL_FALSE_0 = "0";
    public static final String ATTVAL_FLOAT = "float";
    public static final String ATTVAL_HEXBINARY = "hexBinary";
    public static final String ATTVAL_ID = "ID";
    public static final String ATTVAL_IDREF = "IDREF";
    public static final String ATTVAL_IDREFS = "IDREFS";
    public static final String ATTVAL_INT = "int";
    public static final String ATTVAL_INTEGER = "integer";
    public static final String ATTVAL_LANGUAGE = "language";
    public static final String ATTVAL_LAX = "lax";
    public static final String ATTVAL_LIST = "list";
    public static final String ATTVAL_LONG = "long";
    public static final String ATTVAL_MONTH = "gMonth";
    public static final String ATTVAL_MONTHDAY = "gMonthDay";
    public static final String ATTVAL_NAME = "Name";
    public static final String ATTVAL_NCNAME = "NCName";
    public static final String ATTVAL_NEGATIVEINTEGER = "negativeInteger";
    public static final String ATTVAL_NMTOKEN = "NMTOKEN";
    public static final String ATTVAL_NMTOKENS = "NMTOKENS";
    public static final String ATTVAL_NONNEGATIVEINTEGER = "nonNegativeInteger";
    public static final String ATTVAL_NONPOSITIVEINTEGER = "nonPositiveInteger";
    public static final String ATTVAL_NORMALIZEDSTRING = "normalizedString";
    public static final String ATTVAL_NOTATION = "NOTATION";
    public static final String ATTVAL_OPTIONAL = "optional";
    public static final String ATTVAL_POSITIVEINTEGER = "positiveInteger";
    public static final String ATTVAL_POUNDALL = "#all";
    public static final String ATTVAL_PRESERVE = "preserve";
    public static final String ATTVAL_PROHIBITED = "prohibited";
    public static final String ATTVAL_QNAME = "QName";
    public static final String ATTVAL_QUALIFIED = "qualified";
    public static final String ATTVAL_REPLACE = "replace";
    public static final String ATTVAL_REQUIRED = "required";
    public static final String ATTVAL_RESTRICTION = "restriction";
    public static final String ATTVAL_SHORT = "short";
    public static final String ATTVAL_SKIP = "skip";
    public static final String ATTVAL_STRICT = "strict";
    public static final String ATTVAL_STRING = "string";
    public static final String ATTVAL_SUBSTITUTION = "substitution";
    public static final String ATTVAL_TIME = "time";
    public static final String ATTVAL_TOKEN = "token";
    public static final String ATTVAL_TRUE = "true";
    public static final String ATTVAL_TRUE_1 = "1";
    public static final String ATTVAL_TWOPOUNDANY = "##any";
    public static final String ATTVAL_TWOPOUNDLOCAL = "##local";
    public static final String ATTVAL_TWOPOUNDOTHER = "##other";
    public static final String ATTVAL_TWOPOUNDTARGETNS = "##targetNamespace";
    public static final String ATTVAL_UNBOUNDED = "unbounded";
    public static final String ATTVAL_UNION = "union";
    public static final String ATTVAL_UNQUALIFIED = "unqualified";
    public static final String ATTVAL_UNSIGNEDBYTE = "unsignedByte";
    public static final String ATTVAL_UNSIGNEDINT = "unsignedInt";
    public static final String ATTVAL_UNSIGNEDLONG = "unsignedLong";
    public static final String ATTVAL_UNSIGNEDSHORT = "unsignedShort";
    public static final String ATTVAL_YEAR = "gYear";
    public static final String ATTVAL_YEARMONTH = "gYearMonth";
    public static final String ATT_ABSTRACT;
    public static final String ATT_ATTRIBUTEFORMDEFAULT;
    public static final String ATT_BASE;
    public static final String ATT_BLOCK;
    public static final String ATT_BLOCKDEFAULT;
    public static final String ATT_DEFAULT;
    public static final String ATT_ELEMENTFORMDEFAULT;
    public static final String ATT_FINAL;
    public static final String ATT_FINALDEFAULT;
    public static final String ATT_FIXED;
    public static final String ATT_FORM;
    public static final String ATT_ID;
    public static final String ATT_ITEMTYPE;
    public static final String ATT_MAXOCCURS;
    public static final String ATT_MEMBERTYPES;
    public static final String ATT_MINOCCURS;
    public static final String ATT_MIXED;
    public static final String ATT_NAME;
    public static final String ATT_NAMESPACE;
    public static final String ATT_NILLABLE;
    public static final String ATT_PROCESSCONTENTS;
    public static final String ATT_PUBLIC;
    public static final String ATT_REF;
    public static final String ATT_REFER;
    public static final String ATT_SCHEMALOCATION;
    public static final String ATT_SOURCE;
    public static final String ATT_SUBSTITUTIONGROUP;
    public static final String ATT_SYSTEM;
    public static final String ATT_TARGETNAMESPACE;
    public static final String ATT_TYPE;
    public static final String ATT_USE;
    public static final String ATT_VALUE;
    public static final String ATT_VERSION;
    public static final String ATT_XML_LANG;
    public static final String ATT_XPATH;
    public static final String ELT_ALL;
    public static final String ELT_ANNOTATION;
    public static final String ELT_ANY;
    public static final String ELT_ANYATTRIBUTE;
    public static final String ELT_APPINFO;
    public static final String ELT_ATTRIBUTE;
    public static final String ELT_ATTRIBUTEGROUP;
    public static final String ELT_CHOICE;
    public static final String ELT_COMPLEXCONTENT;
    public static final String ELT_COMPLEXTYPE;
    public static final String ELT_DOCUMENTATION;
    public static final String ELT_ELEMENT;
    public static final String ELT_ENUMERATION;
    public static final String ELT_EXTENSION;
    public static final String ELT_FIELD;
    public static final String ELT_FRACTIONDIGITS;
    public static final String ELT_GROUP;
    public static final String ELT_IMPORT;
    public static final String ELT_INCLUDE;
    public static final String ELT_KEY;
    public static final String ELT_KEYREF;
    public static final String ELT_LENGTH;
    public static final String ELT_LIST;
    public static final String ELT_MAXEXCLUSIVE;
    public static final String ELT_MAXINCLUSIVE;
    public static final String ELT_MAXLENGTH;
    public static final String ELT_MINEXCLUSIVE;
    public static final String ELT_MININCLUSIVE;
    public static final String ELT_MINLENGTH;
    public static final String ELT_NOTATION;
    public static final String ELT_PATTERN;
    public static final String ELT_REDEFINE;
    public static final String ELT_RESTRICTION;
    public static final String ELT_SCHEMA;
    public static final String ELT_SELECTOR;
    public static final String ELT_SEQUENCE;
    public static final String ELT_SIMPLECONTENT;
    public static final String ELT_SIMPLETYPE;
    public static final String ELT_TOTALDIGITS;
    public static final String ELT_UNION;
    public static final String ELT_UNIQUE;
    public static final String ELT_WHITESPACE;
    public static final short FORM_QUALIFIED = (short) 1;
    public static final short FORM_UNQUALIFIED = (short) 0;
    public static final int OCCURRENCE_UNBOUNDED = -1;
    public static final String URI_SCHEMAFORSCHEMA;
    public static final String URI_XSI;
    public static final short USE_OPTIONAL = (short) 0;
    public static final short USE_PROHIBITED = (short) 2;
    public static final short USE_REQUIRED = (short) 1;
    public static final String XSI_NIL;
    public static final String XSI_NONAMESPACESCHEMALOCATION;
    public static final String XSI_SCHEMALOCATION;
    public static final String XSI_TYPE;

    static {
        URI_XSI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI.intern();
        XSI_SCHEMALOCATION = "schemaLocation".intern();
        XSI_NONAMESPACESCHEMALOCATION = "noNamespaceSchemaLocation".intern();
        XSI_TYPE = "type".intern();
        XSI_NIL = "nil".intern();
        URI_SCHEMAFORSCHEMA = XMLGrammarDescription.XML_SCHEMA.intern();
        ELT_ALL = "all".intern();
        ELT_ANNOTATION = "annotation".intern();
        ELT_ANY = "any".intern();
        ELT_ANYATTRIBUTE = "anyAttribute".intern();
        ELT_APPINFO = "appinfo".intern();
        ELT_ATTRIBUTE = "attribute".intern();
        ELT_ATTRIBUTEGROUP = "attributeGroup".intern();
        ELT_CHOICE = "choice".intern();
        ELT_COMPLEXCONTENT = "complexContent".intern();
        ELT_COMPLEXTYPE = "complexType".intern();
        ELT_DOCUMENTATION = "documentation".intern();
        ELT_ELEMENT = "element".intern();
        ELT_ENUMERATION = "enumeration".intern();
        ELT_EXTENSION = ATTVAL_EXTENSION.intern();
        ELT_FIELD = "field".intern();
        ELT_FRACTIONDIGITS = "fractionDigits".intern();
        ELT_GROUP = "group".intern();
        ELT_IMPORT = "import".intern();
        ELT_INCLUDE = "include".intern();
        ELT_KEY = "key".intern();
        ELT_KEYREF = "keyref".intern();
        ELT_LENGTH = "length".intern();
        ELT_LIST = ATTVAL_LIST.intern();
        ELT_MAXEXCLUSIVE = "maxExclusive".intern();
        ELT_MAXINCLUSIVE = "maxInclusive".intern();
        ELT_MAXLENGTH = "maxLength".intern();
        ELT_MINEXCLUSIVE = "minExclusive".intern();
        ELT_MININCLUSIVE = "minInclusive".intern();
        ELT_MINLENGTH = "minLength".intern();
        ELT_NOTATION = "notation".intern();
        ELT_PATTERN = "pattern".intern();
        ELT_REDEFINE = "redefine".intern();
        ELT_RESTRICTION = ATTVAL_RESTRICTION.intern();
        ELT_SCHEMA = "schema".intern();
        ELT_SELECTOR = "selector".intern();
        ELT_SEQUENCE = "sequence".intern();
        ELT_SIMPLECONTENT = "simpleContent".intern();
        ELT_SIMPLETYPE = "simpleType".intern();
        ELT_TOTALDIGITS = "totalDigits".intern();
        ELT_UNION = ATTVAL_UNION.intern();
        ELT_UNIQUE = "unique".intern();
        ELT_WHITESPACE = "whiteSpace".intern();
        ATT_ABSTRACT = "abstract".intern();
        ATT_ATTRIBUTEFORMDEFAULT = "attributeFormDefault".intern();
        ATT_BASE = "base".intern();
        ATT_BLOCK = "block".intern();
        ATT_BLOCKDEFAULT = "blockDefault".intern();
        ATT_DEFAULT = "default".intern();
        ATT_ELEMENTFORMDEFAULT = "elementFormDefault".intern();
        ATT_FINAL = "final".intern();
        ATT_FINALDEFAULT = "finalDefault".intern();
        ATT_FIXED = "fixed".intern();
        ATT_FORM = "form".intern();
        ATT_ID = "id".intern();
        ATT_ITEMTYPE = "itemType".intern();
        ATT_MAXOCCURS = "maxOccurs".intern();
        ATT_MEMBERTYPES = "memberTypes".intern();
        ATT_MINOCCURS = "minOccurs".intern();
        ATT_MIXED = "mixed".intern();
        ATT_NAME = "name".intern();
        ATT_NAMESPACE = "namespace".intern();
        ATT_NILLABLE = "nillable".intern();
        ATT_PROCESSCONTENTS = "processContents".intern();
        ATT_REF = "ref".intern();
        ATT_REFER = "refer".intern();
        ATT_SCHEMALOCATION = "schemaLocation".intern();
        ATT_SOURCE = "source".intern();
        ATT_SUBSTITUTIONGROUP = "substitutionGroup".intern();
        ATT_SYSTEM = "system".intern();
        ATT_PUBLIC = "public".intern();
        ATT_TARGETNAMESPACE = "targetNamespace".intern();
        ATT_TYPE = "type".intern();
        ATT_USE = "use".intern();
        ATT_VALUE = "value".intern();
        ATT_VERSION = OutputKeys.VERSION.intern();
        ATT_XML_LANG = "xml:lang".intern();
        ATT_XPATH = "xpath".intern();
    }
}
