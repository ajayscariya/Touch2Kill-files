package com.inmobi.commons.core.p003c;

import android.content.ContentValues;
import com.inmobi.commons.core.p002b.DbStore;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.List;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.core.c.d */
public class TelemetryDao {
    private static final String f1554a;

    static {
        f1554a = TelemetryDao.class.getSimpleName();
    }

    public TelemetryDao() {
        DbStore a = DbStore.m1579a();
        a.m1584a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.m1584a("metric", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL )");
        a.m1587b();
    }

    public void m1621a(TelemetryEvent telemetryEvent) {
        DbStore a = DbStore.m1579a();
        a.m1585a("telemetry", telemetryEvent.m1632e());
        a.m1587b();
    }

    public void m1622a(String str, String str2, String str3) {
        DbStore a = DbStore.m1579a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("componentType", str);
        contentValues.put("eventType", str2);
        contentValues.put("payload", str3);
        a.m1585a("metric", contentValues);
        a.m1587b();
    }

    public List<ContentValues> m1619a() {
        DbStore a = DbStore.m1579a();
        List<ContentValues> a2 = a.m1583a("metric", null, null, null, null, null, null, null);
        a.m1587b();
        m1624b();
        return a2;
    }

    public void m1624b() {
        DbStore a = DbStore.m1579a();
        a.m1582a("metric", null, null);
        a.m1587b();
    }

    public void m1623a(List<TelemetryEvent> list) {
        DbStore a = DbStore.m1579a();
        for (TelemetryEvent e : list) {
            a.m1585a("telemetry", e.m1632e());
        }
        a.m1587b();
    }

    public List<TelemetryEvent> m1620a(int i) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1554a, "Querying db for events");
        DbStore a = DbStore.m1579a();
        List<ContentValues> a2 = a.m1583a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
        m1618b(a2);
        List<TelemetryEvent> arrayList = new ArrayList();
        a.m1587b();
        for (ContentValues a3 : a2) {
            arrayList.add(TelemetryEvent.m1626a(a3));
        }
        return arrayList;
    }

    private void m1618b(List<ContentValues> list) {
        if (!list.isEmpty()) {
            DbStore a = DbStore.m1579a();
            String str = XMLConstants.NULL_NS_URI;
            int i = 0;
            while (i < list.size() - 1) {
                String str2 = str + ((ContentValues) list.get(i)).getAsString("id") + ",";
                i++;
                str = str2;
            }
            str = str + ((ContentValues) list.get(list.size() - 1)).getAsString("id");
            Logger.m1744a(InternalLogLevel.INTERNAL, f1554a, "Deleting events with id: " + str);
            int a2 = a.m1582a("telemetry", "id IN (" + str + ")", null);
            a.m1587b();
            Logger.m1744a(InternalLogLevel.INTERNAL, f1554a, "Deleted Count: " + a2);
        }
    }

    public int m1625c() {
        DbStore a = DbStore.m1579a();
        int a2 = a.m1580a("telemetry");
        a.m1587b();
        return a2;
    }
}
