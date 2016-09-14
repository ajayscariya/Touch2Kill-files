package com.inmobi.rendering.p005a;

import android.content.ContentValues;
import com.inmobi.commons.core.p002b.DbStore;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.rendering.a.b */
public class ClickDao {
    public static final String[] f1899a;
    private static final String f1900b;

    static {
        f1900b = ClickDao.class.getSimpleName();
        f1899a = new String[]{"id", "pending_attempts", DatabaseOpenHelper.HISTORY_ROW_URL, "ping_in_webview", "follow_redirect", "ts"};
    }

    public ClickDao() {
        DbStore a = DbStore.m1579a();
        a.m1584a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL)");
        a.m1587b();
    }

    public boolean m1996a() {
        return DbStore.m1579a().m1580a("click") == 0;
    }

    public synchronized boolean m1997a(Click click, int i) {
        ContentValues c = m1999c(click);
        DbStore a = DbStore.m1579a();
        if (a.m1580a("click") >= i) {
            Map hashMap = new HashMap();
            hashMap.put("errorCode", "MaxDbLimitBreach");
            TelemetryComponent.m5070a().m5092a("ads", "PingDiscarded", hashMap);
            Logger.m1744a(InternalLogLevel.INTERNAL, f1900b, "Pruning persistent store to remove the oldest entry ...");
            Click a2 = m1993a((ContentValues) a.m1583a("click", f1899a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0));
            Logger.m1744a(InternalLogLevel.INTERNAL, f1900b, "Deleting click (" + a2.f1892a + ")");
            m1998b(a2);
        }
        a.m1585a("click", c);
        a.m1587b();
        return true;
    }

    public List<Click> m1994a(int i, int i2) {
        List<Click> arrayList = new ArrayList();
        DbStore a = DbStore.m1579a();
        if (a.m1580a("click") == 0) {
            return arrayList;
        }
        List<ContentValues> a2 = a.m1583a("click", f1899a, null, null, "ts", "ts < " + String.valueOf(System.currentTimeMillis() - ((long) i2)), "ts ASC ", -1 == i ? null : Integer.toString(i));
        a.m1587b();
        for (ContentValues a3 : a2) {
            arrayList.add(m1993a(a3));
        }
        return arrayList;
    }

    public void m1995a(Click click) {
        DbStore a = DbStore.m1579a();
        a.m1581a("click", m1999c(click), "id = ?", new String[]{String.valueOf(click.f1892a)});
        a.m1587b();
    }

    public void m1998b(Click click) {
        DbStore a = DbStore.m1579a();
        a.m1582a("click", "id = ?", new String[]{String.valueOf(click.f1892a)});
        a.m1587b();
    }

    public Click m1993a(ContentValues contentValues) {
        int intValue = contentValues.getAsInteger("id").intValue();
        int intValue2 = contentValues.getAsInteger("pending_attempts").intValue();
        return new Click(intValue, contentValues.getAsString(DatabaseOpenHelper.HISTORY_ROW_URL), Boolean.valueOf(contentValues.getAsString("follow_redirect")).booleanValue(), Boolean.valueOf(contentValues.getAsString("ping_in_webview")).booleanValue(), intValue2, Long.valueOf(contentValues.getAsString("ts")).longValue());
    }

    public ContentValues m1999c(Click click) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(click.f1892a));
        contentValues.put(DatabaseOpenHelper.HISTORY_ROW_URL, click.f1893b);
        contentValues.put("pending_attempts", Integer.valueOf(click.f1895d));
        contentValues.put("ts", Long.toString(click.f1894c));
        contentValues.put("follow_redirect", Boolean.toString(click.f1898g));
        contentValues.put("ping_in_webview", Boolean.toString(click.f1897f));
        return contentValues;
    }
}
