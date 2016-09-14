package com.applovin.impl.adview;

import mf.javax.xml.XMLConstants;

/* renamed from: com.applovin.impl.adview.j */
class C0217j implements Runnable {
    final /* synthetic */ AdViewControllerImpl f70a;

    private C0217j(AdViewControllerImpl adViewControllerImpl) {
        this.f70a = adViewControllerImpl;
    }

    public void run() {
        try {
            this.f64a.f3771i.loadDataWithBaseURL("/", "<html></html>", "text/html", null, XMLConstants.NULL_NS_URI);
        } catch (Exception e) {
        }
    }
}
