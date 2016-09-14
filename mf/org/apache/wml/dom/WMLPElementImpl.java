package mf.org.apache.wml.dom;

import mf.org.apache.wml.WMLPElement;

public class WMLPElementImpl extends WMLElementImpl implements WMLPElement {
    private static final long serialVersionUID = 4263257796458499960L;

    public WMLPElementImpl(WMLDocumentImpl owner, String tagName) {
        super(owner, tagName);
    }

    public void setClassName(String newValue) {
        setAttribute("class", newValue);
    }

    public String getClassName() {
        return getAttribute("class");
    }

    public void setMode(String newValue) {
        setAttribute("mode", newValue);
    }

    public String getMode() {
        return getAttribute("mode");
    }

    public void setXmlLang(String newValue) {
        setAttribute("xml:lang", newValue);
    }

    public String getXmlLang() {
        return getAttribute("xml:lang");
    }

    public void setAlign(String newValue) {
        setAttribute("align", newValue);
    }

    public String getAlign() {
        return getAttribute("align");
    }

    public void setId(String newValue) {
        setAttribute("id", newValue);
    }

    public String getId() {
        return getAttribute("id");
    }
}
