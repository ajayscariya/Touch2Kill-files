package com.inmobi.commons.core.p002b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.commons.core.b.b */
public final class DbStore {
    private static final String f1525a;
    private static volatile DbStore f1526b;
    private static final Object f1527c;
    private static final Object f1528d;
    private static int f1529e;
    private SQLiteDatabase f1530f;

    static {
        f1525a = DbStore.class.getSimpleName();
        f1527c = new Object();
        f1528d = new Object();
        f1529e = 0;
    }

    private DbStore() {
        try {
            this.f1530f = new DbHelper(SdkContext.m1562b()).getWritableDatabase();
            f1526b = this;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1525a, "Problem while getting writable database connection.", e);
        }
    }

    public static synchronized DbStore m1579a() {
        DbStore dbStore;
        synchronized (DbStore.class) {
            synchronized (f1528d) {
                f1529e++;
            }
            dbStore = f1526b;
            if (dbStore == null) {
                synchronized (f1527c) {
                    dbStore = f1526b;
                    if (dbStore == null) {
                        f1526b = new DbStore();
                        dbStore = f1526b;
                    }
                }
            }
        }
        return dbStore;
    }

    public boolean m1585a(String str, ContentValues contentValues) {
        return this.f1530f.insertWithOnConflict(str, null, contentValues, 4) != -1;
    }

    public int m1582a(String str, String str2, String[] strArr) {
        return this.f1530f.delete(str, str2, strArr);
    }

    public int m1581a(String str, ContentValues contentValues, String str2, String[] strArr) {
        return this.f1530f.updateWithOnConflict(str, contentValues, str2, strArr, 4);
    }

    public List<ContentValues> m1583a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query = this.f1530f.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        List<ContentValues> arrayList = new ArrayList();
        if (query.moveToFirst()) {
            do {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(query, contentValues);
                arrayList.add(contentValues);
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    public int m1580a(String str) {
        Cursor rawQuery = this.f1530f.rawQuery("SELECT COUNT(*) FROM " + str + " ; ", null);
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public int m1586b(String str, String str2, String[] strArr) {
        Cursor rawQuery = this.f1530f.rawQuery("SELECT COUNT(*) FROM " + str + " WHERE " + str2 + " ; ", strArr);
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public void m1584a(String str, String str2) {
        this.f1530f.execSQL("CREATE TABLE IF NOT EXISTS " + str + str2 + ";");
    }

    public void m1587b() {
        synchronized (f1528d) {
            f1529e--;
            if (f1529e == 0) {
                this.f1530f.close();
                f1526b = null;
            }
        }
    }
}
