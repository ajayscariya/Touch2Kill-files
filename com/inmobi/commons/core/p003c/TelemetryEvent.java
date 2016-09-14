package com.inmobi.commons.core.p003c;

import android.content.ContentValues;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.core.c.e */
public class TelemetryEvent {
    private static final String f1555a;
    private String f1556b;
    private String f1557c;
    private long f1558d;
    private String f1559e;

    static {
        f1555a = TelemetryEvent.class.getSimpleName();
    }

    public TelemetryEvent(String str, String str2) {
        this.f1557c = str;
        this.f1556b = str2;
        this.f1559e = null;
        this.f1558d = System.currentTimeMillis();
    }

    public TelemetryEvent(String str, String str2, String str3) {
        this.f1557c = str;
        this.f1556b = str2;
        this.f1559e = str3;
        this.f1558d = System.currentTimeMillis();
    }

    public String m1627a() {
        return this.f1557c;
    }

    public String m1629b() {
        return this.f1556b;
    }

    public String m1630c() {
        return this.f1559e == null ? XMLConstants.NULL_NS_URI : this.f1559e;
    }

    public long m1631d() {
        return this.f1558d;
    }

    public void m1628a(String str) {
        this.f1559e = str;
    }

    public String toString() {
        return m1629b() + "@" + m1627a() + " ";
    }

    public static TelemetryEvent m1626a(ContentValues contentValues) {
        String asString = contentValues.getAsString("eventType");
        String asString2 = contentValues.getAsString("componentType");
        String asString3 = contentValues.getAsString("payload");
        long longValue = Long.valueOf(contentValues.getAsString("ts")).longValue();
        TelemetryEvent telemetryEvent = new TelemetryEvent(asString2, asString, asString3);
        telemetryEvent.f1558d = longValue;
        return telemetryEvent;
    }

    public ContentValues m1632e() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("componentType", m1627a());
        contentValues.put("eventType", m1629b());
        contentValues.put("payload", m1630c());
        contentValues.put("ts", String.valueOf(m1631d()));
        return contentValues;
    }
}
