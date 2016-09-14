package com.inmobi.ads;

import android.content.ContentValues;

/* renamed from: com.inmobi.ads.a */
class Ad {
    private static final String f1417a;
    private String f1418b;
    private String f1419c;
    private String f1420d;
    private long f1421e;
    private long f1422f;
    private String f1423g;

    static {
        f1417a = Ad.class.getSimpleName();
    }

    public Ad(AdNetworkResponse adNetworkResponse, String str, String str2) {
        this.f1418b = adNetworkResponse.m1504b().m5046b();
        this.f1419c = adNetworkResponse.m1504b().m5049c();
        this.f1420d = str;
        this.f1421e = adNetworkResponse.m1504b().m5053e();
        this.f1422f = System.currentTimeMillis();
        this.f1423g = str2;
    }

    public Ad(ContentValues contentValues) {
        this.f1418b = contentValues.getAsString("ad_type");
        this.f1419c = contentValues.getAsString("ad_size");
        this.f1420d = contentValues.getAsString("ad_content");
        this.f1421e = contentValues.getAsLong("placement_id").longValue();
        this.f1422f = contentValues.getAsLong("placement_id").longValue();
        this.f1423g = contentValues.getAsString("imp_id");
    }

    public ContentValues m1433a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_type", this.f1418b);
        contentValues.put("ad_size", this.f1419c);
        contentValues.put("ad_content", this.f1420d);
        contentValues.put("placement_id", Long.valueOf(this.f1421e));
        contentValues.put("insertion_ts", Long.valueOf(this.f1422f));
        contentValues.put("imp_id", this.f1423g);
        return contentValues;
    }

    public String m1434b() {
        return this.f1420d;
    }

    public String m1435c() {
        return this.f1423g;
    }
}
