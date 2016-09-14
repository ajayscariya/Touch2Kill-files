package com.inmobi.commons.core.network;

import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.network.c */
public class NetworkResponse {
    private NetworkRequest f1617a;
    private String f1618b;
    private NetworkError f1619c;
    private Map<String, List<String>> f1620d;

    public NetworkResponse(NetworkRequest networkRequest) {
        this.f1617a = networkRequest;
    }

    public boolean m1737a() {
        return this.f1619c != null;
    }

    public String m1738b() {
        return this.f1618b;
    }

    public void m1735a(String str) {
        this.f1618b = str;
    }

    public void m1736a(Map<String, List<String>> map) {
        this.f1620d = map;
    }

    public NetworkError m1739c() {
        return this.f1619c;
    }

    public void m1734a(NetworkError networkError) {
        this.f1619c = networkError;
    }
}
