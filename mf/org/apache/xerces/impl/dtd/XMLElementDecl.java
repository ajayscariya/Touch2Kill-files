package mf.org.apache.xerces.impl.dtd;

import mf.org.apache.xerces.impl.dtd.models.ContentModelValidator;
import mf.org.apache.xerces.xni.QName;

public class XMLElementDecl {
    public static final short TYPE_ANY = (short) 0;
    public static final short TYPE_CHILDREN = (short) 3;
    public static final short TYPE_EMPTY = (short) 1;
    public static final short TYPE_MIXED = (short) 2;
    public static final short TYPE_SIMPLE = (short) 4;
    public ContentModelValidator contentModelValidator;
    public final QName name;
    public int scope;
    public final XMLSimpleType simpleType;
    public short type;

    public XMLElementDecl() {
        this.name = new QName();
        this.scope = -1;
        this.type = (short) -1;
        this.simpleType = new XMLSimpleType();
    }

    public void setValues(QName name, int scope, short type, ContentModelValidator contentModelValidator, XMLSimpleType simpleType) {
        this.name.setValues(name);
        this.scope = scope;
        this.type = type;
        this.contentModelValidator = contentModelValidator;
        this.simpleType.setValues(simpleType);
    }

    public void clear() {
        this.name.clear();
        this.type = (short) -1;
        this.scope = -1;
        this.contentModelValidator = null;
        this.simpleType.clear();
    }
}
