package mf.org.apache.wml.dom;

import mf.org.apache.wml.WMLPostfieldElement;

public class WMLPostfieldElementImpl extends WMLElementImpl implements WMLPostfieldElement {
    private static final long serialVersionUID = -1169432003991642980L;

    public WMLPostfieldElementImpl(WMLDocumentImpl owner, String tagName) {
        super(owner, tagName);
    }

    public void setValue(String newValue) {
        setAttribute("value", newValue);
    }

    public String getValue() {
        return getAttribute("value");
    }

    public void setClassName(String newValue) {
        setAttribute("class", newValue);
    }

    public String getClassName() {
        return getAttribute("class");
    }

    public void setId(String newValue) {
        setAttribute("id", newValue);
    }

    public String getId() {
        return getAttribute("id");
    }

    public void setName(String newValue) {
        setAttribute("name", newValue);
    }

    public String getName() {
        return getAttribute("name");
    }
}
