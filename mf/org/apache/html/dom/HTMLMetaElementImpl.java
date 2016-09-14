package mf.org.apache.html.dom;

import com.applovin.sdk.AppLovinEventTypes;
import mf.org.w3c.dom.html.HTMLMetaElement;

public class HTMLMetaElementImpl extends HTMLElementImpl implements HTMLMetaElement {
    private static final long serialVersionUID = -2401961905874264272L;

    public String getContent() {
        return getAttribute(AppLovinEventTypes.USER_VIEWED_CONTENT);
    }

    public void setContent(String content) {
        setAttribute(AppLovinEventTypes.USER_VIEWED_CONTENT, content);
    }

    public String getHttpEquiv() {
        return getAttribute("http-equiv");
    }

    public void setHttpEquiv(String httpEquiv) {
        setAttribute("http-equiv", httpEquiv);
    }

    public String getName() {
        return getAttribute("name");
    }

    public void setName(String name) {
        setAttribute("name", name);
    }

    public String getScheme() {
        return getAttribute("scheme");
    }

    public void setScheme(String scheme) {
        setAttribute("scheme", scheme);
    }

    public HTMLMetaElementImpl(HTMLDocumentImpl owner, String name) {
        super(owner, name);
    }
}
