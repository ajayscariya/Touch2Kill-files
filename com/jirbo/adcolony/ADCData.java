package com.jirbo.adcolony;

import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.C0866R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

public class ADCData {
    static C0670i f2166a;
    static C0670i f2167b;
    static C0670i f2168c;

    /* renamed from: com.jirbo.adcolony.ADCData.i */
    static class C0670i {
        C0670i() {
        }

        boolean m2396m() {
            return false;
        }

        boolean m2391f() {
            return false;
        }

        boolean m2394k() {
            return false;
        }

        boolean m2398p() {
            return b_() || m2388c();
        }

        boolean b_() {
            return false;
        }

        boolean m2388c() {
            return false;
        }

        boolean m2386a() {
            return false;
        }

        boolean c_() {
            return false;
        }

        boolean m2392g() {
            return true;
        }

        C1423g m2397n() {
            return null;
        }

        C1419c m2393h() {
            return null;
        }

        String m2387b() {
            return m2399q();
        }

        double m2389d() {
            return 0.0d;
        }

        int m2390e() {
            return 0;
        }

        boolean m2395l() {
            return false;
        }

        public String toString() {
            return m2399q();
        }

        String m2399q() {
            ae c1442y = new C1442y();
            m2384a(c1442y);
            return c1442y.toString();
        }

        void m2384a(ae aeVar) {
        }

        void m2385a(ae aeVar, String str) {
            if (str != null) {
                aeVar.m2516b('\"');
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    switch (charAt) {
                        case ConnectionResult.INTERNAL_ERROR /*8*/:
                            aeVar.m2514a("\\b");
                            break;
                        case ConnectionResult.SERVICE_INVALID /*9*/:
                            aeVar.m2514a("\\t");
                            break;
                        case MetaData.DEFAULT_MAX_ADS /*10*/:
                            aeVar.m2514a("\\n");
                            break;
                        case Tokens.EXPRTOKEN_NODETYPE_COMMENT /*12*/:
                            aeVar.m2514a("\\f");
                            break;
                        case ConnectionResult.CANCELED /*13*/:
                            aeVar.m2514a("\\r");
                            break;
                        case Tokens.EXPRTOKEN_AXISNAME_ANCESTOR_OR_SELF /*34*/:
                            aeVar.m2514a("\\\"");
                            break;
                        case Tokens.EXPRTOKEN_NUMBER /*47*/:
                            aeVar.m2514a("\\/");
                            break;
                        case C0866R.styleable.Theme_alertDialogButtonGroupStyle /*92*/:
                            aeVar.m2514a("\\\\");
                            break;
                        default:
                            if (charAt >= ' ' && charAt <= '~') {
                                aeVar.m2516b(charAt);
                                break;
                            }
                            aeVar.m2514a("\\u");
                            int i2 = charAt;
                            for (int i3 = 0; i3 < 4; i3++) {
                                int i4 = (i2 >> 12) & 15;
                                i2 <<= 4;
                                if (i4 <= 9) {
                                    aeVar.m2512a((long) i4);
                                } else {
                                    aeVar.m2516b((char) ((i4 - 10) + 97));
                                }
                            }
                            break;
                    }
                }
                aeVar.m2516b('\"');
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.a */
    static class C1417a extends C0670i {
        C1417a() {
        }

        boolean m5222a() {
            return true;
        }

        String m5223b() {
            return SchemaSymbols.ATTVAL_FALSE;
        }

        void m5221a(ae aeVar) {
            aeVar.m2514a(SchemaSymbols.ATTVAL_FALSE);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.b */
    static class C1418b extends C0670i {
        int f4507a;

        C1418b(int i) {
            this.f4507a = i;
        }

        boolean m5225c() {
            return true;
        }

        double m5226d() {
            return (double) this.f4507a;
        }

        int m5227e() {
            return this.f4507a;
        }

        void m5224a(ae aeVar) {
            aeVar.m2512a((long) this.f4507a);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.c */
    static class C1419c extends C0670i {
        ArrayList<C0670i> f4508a;

        C1419c() {
            this.f4508a = new ArrayList();
        }

        boolean m5246f() {
            return true;
        }

        boolean m5247g() {
            return this.f4508a.size() == 0 || (this.f4508a.size() == 1 && ((C0670i) this.f4508a.get(0)).m2392g());
        }

        C1419c m5249h() {
            return this;
        }

        void m5239a(ae aeVar) {
            int size = this.f4508a.size();
            if (size == 0) {
                aeVar.m2514a("[]");
            } else if (size == 1 && ((C0670i) this.f4508a.get(0)).m2392g()) {
                aeVar.m2514a("[");
                ((C0670i) this.f4508a.get(0)).m2384a(aeVar);
                aeVar.m2514a("]");
            } else {
                aeVar.m2520b("[");
                aeVar.f2457i += 2;
                int i = 0;
                int i2 = 1;
                while (i < size) {
                    int i3;
                    if (i2 != 0) {
                        i3 = 0;
                    } else {
                        aeVar.m2523c(',');
                        i3 = i2;
                    }
                    ((C0670i) this.f4508a.get(i)).m2384a(aeVar);
                    i++;
                    i2 = i3;
                }
                aeVar.m2525d();
                aeVar.f2457i -= 2;
                aeVar.m2514a("]");
            }
        }

        int m5250i() {
            return this.f4508a.size();
        }

        void m5251j() {
            this.f4508a.clear();
        }

        C1419c m5234a(C0670i c0670i) {
            this.f4508a.add(c0670i);
            return this;
        }

        C1419c m5235a(String str) {
            m5234a(new C1422f(str));
            return this;
        }

        C1419c m5230a(double d) {
            m5234a(new C1421e(d));
            return this;
        }

        C1419c m5231a(int i) {
            m5234a(new C1418b(i));
            return this;
        }

        C1419c m5236a(boolean z) {
            m5234a(z ? ADCData.f2166a : ADCData.f2167b);
            return this;
        }

        C1419c m5233a(C1419c c1419c) {
            for (int i = 0; i < c1419c.m5250i(); i++) {
                m5234a((C0670i) c1419c.f4508a.get(i));
            }
            return this;
        }

        C1423g m5237a(int i, C1423g c1423g) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null || !c0670i.m2396m()) {
                return c1423g;
            }
            return c0670i.m2397n();
        }

        C1419c m5232a(int i, C1419c c1419c) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null || !c0670i.m2391f()) {
                return c1419c;
            }
            return c0670i.m2393h();
        }

        String m5238a(int i, String str) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null || !c0670i.m2394k()) {
                return str;
            }
            return c0670i.m2387b();
        }

        double m5228a(int i, double d) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null || !c0670i.m2398p()) {
                return d;
            }
            return c0670i.m2389d();
        }

        int m5229a(int i, int i2) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null || !c0670i.m2398p()) {
                return i2;
            }
            return c0670i.m2390e();
        }

        boolean m5240a(int i, boolean z) {
            C0670i c0670i = (C0670i) this.f4508a.get(i);
            if (c0670i == null) {
                return z;
            }
            if (c0670i.m2386a() || c0670i.m2394k()) {
                return c0670i.m2395l();
            }
            return z;
        }

        C1423g m5241b(int i) {
            C1423g a = m5237a(i, null);
            return a != null ? a : new C1423g();
        }

        C1419c m5242c(int i) {
            C1419c a = m5232a(i, null);
            return a != null ? a : new C1419c();
        }

        String m5243d(int i) {
            return m5238a(i, XMLConstants.NULL_NS_URI);
        }

        double m5244e(int i) {
            return m5228a(i, 0.0d);
        }

        int m5245f(int i) {
            return m5229a(i, 0);
        }

        boolean m5248g(int i) {
            return m5240a(i, false);
        }

        C0670i a_() {
            return (C0670i) this.f4508a.remove(this.f4508a.size() - 1);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.d */
    static class C1420d extends C0670i {
        C1420d() {
        }

        boolean c_() {
            return true;
        }

        String m5253b() {
            return "null";
        }

        void m5252a(ae aeVar) {
            aeVar.m2514a("null");
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.e */
    static class C1421e extends C0670i {
        double f4509a;

        C1421e(double d) {
            this.f4509a = d;
        }

        boolean b_() {
            return true;
        }

        double m5255d() {
            return this.f4509a;
        }

        int m5256e() {
            return (int) this.f4509a;
        }

        void m5254a(ae aeVar) {
            aeVar.m2511a(this.f4509a);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.f */
    static class C1422f extends C0670i implements Serializable {
        String f4510a;

        C1422f(String str) {
            this.f4510a = str;
        }

        boolean m5261k() {
            return true;
        }

        String m5258b() {
            return this.f4510a;
        }

        double m5259d() {
            try {
                return Double.parseDouble(this.f4510a);
            } catch (NumberFormatException e) {
                return 0.0d;
            }
        }

        int m5260e() {
            return (int) m5259d();
        }

        boolean m5262l() {
            String toLowerCase = this.f4510a.toLowerCase();
            if (toLowerCase.equals(SchemaSymbols.ATTVAL_TRUE) || toLowerCase.equals("yes")) {
                return true;
            }
            return false;
        }

        void m5257a(ae aeVar) {
            m2385a(aeVar, this.f4510a);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.g */
    static class C1423g extends C0670i implements Serializable {
        HashMap<String, C0670i> f4511a;
        ArrayList<String> f4512b;

        C1423g() {
            this.f4511a = new HashMap();
            this.f4512b = new ArrayList();
        }

        boolean m5286m() {
            return true;
        }

        boolean m5284g() {
            return this.f4511a.size() < 0 || (this.f4511a.size() == 1 && ((C0670i) this.f4511a.get(this.f4512b.get(0))).m2392g());
        }

        C1423g m5287n() {
            return this;
        }

        void m5270a(ae aeVar) {
            int size = this.f4512b.size();
            if (size == 0) {
                aeVar.m2514a("{}");
            } else if (size == 1 && ((C0670i) this.f4511a.get(this.f4512b.get(0))).m2392g()) {
                aeVar.m2514a("{");
                r0 = (String) this.f4512b.get(0);
                r1 = (C0670i) this.f4511a.get(r0);
                m2385a(aeVar, r0);
                aeVar.m2516b(':');
                r1.m2384a(aeVar);
                aeVar.m2514a("}");
            } else {
                aeVar.m2520b("{");
                aeVar.f2457i += 2;
                int i = 0;
                int i2 = 1;
                while (i < size) {
                    int i3;
                    if (i2 != 0) {
                        i3 = 0;
                    } else {
                        aeVar.m2523c(',');
                        i3 = i2;
                    }
                    r0 = (String) this.f4512b.get(i);
                    r1 = (C0670i) this.f4511a.get(r0);
                    m2385a(aeVar, r0);
                    aeVar.m2516b(':');
                    if (!r1.m2392g()) {
                        aeVar.m2525d();
                    }
                    r1.m2384a(aeVar);
                    i++;
                    i2 = i3;
                }
                aeVar.m2525d();
                aeVar.f2457i -= 2;
                aeVar.m2514a("}");
            }
        }

        int m5288o() {
            return this.f4512b.size();
        }

        String m5267a(int i) {
            return (String) this.f4512b.get(i);
        }

        boolean m5272a(String str) {
            return this.f4511a.containsKey(str);
        }

        C1423g m5266a(String str, C1423g c1423g) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null || !c0670i.m2396m()) {
                return c1423g;
            }
            return c0670i.m2397n();
        }

        C1419c m5265a(String str, C1419c c1419c) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null || !c0670i.m2391f()) {
                return c1419c;
            }
            return c0670i.m2393h();
        }

        ArrayList<String> m5269a(String str, ArrayList<String> arrayList) {
            C1419c c = m5279c(str);
            if (c != null) {
                arrayList = new ArrayList();
                for (int i = 0; i < c.m5250i(); i++) {
                    String d = c.m5243d(i);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            return arrayList;
        }

        String m5268a(String str, String str2) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null || !c0670i.m2394k()) {
                return str2;
            }
            return c0670i.m2387b();
        }

        double m5263a(String str, double d) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null || !c0670i.m2398p()) {
                return d;
            }
            return c0670i.m2389d();
        }

        int m5264a(String str, int i) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null || !c0670i.m2398p()) {
                return i;
            }
            return c0670i.m2390e();
        }

        boolean m5273a(String str, boolean z) {
            C0670i c0670i = (C0670i) this.f4511a.get(str);
            if (c0670i == null) {
                return z;
            }
            if (c0670i.m2386a() || c0670i.m2394k()) {
                return c0670i.m2395l();
            }
            return z;
        }

        C1423g m5274b(String str) {
            C1423g a = m5266a(str, null);
            return a != null ? a : new C1423g();
        }

        C1419c m5279c(String str) {
            C1419c a = m5265a(str, null);
            return a != null ? a : new C1419c();
        }

        ArrayList<String> m5280d(String str) {
            ArrayList<String> a = m5269a(str, null);
            if (a == null) {
                return new ArrayList();
            }
            return a;
        }

        String m5281e(String str) {
            return m5268a(str, XMLConstants.NULL_NS_URI);
        }

        double m5282f(String str) {
            return m5263a(str, 0.0d);
        }

        int m5283g(String str) {
            return m5264a(str, 0);
        }

        boolean m5285h(String str) {
            return m5273a(str, false);
        }

        void m5271a(String str, C0670i c0670i) {
            if (!this.f4511a.containsKey(str)) {
                this.f4512b.add(str);
            }
            this.f4511a.put(str, c0670i);
        }

        void m5277b(String str, String str2) {
            m5271a(str, new C1422f(str2));
        }

        void m5275b(String str, double d) {
            m5271a(str, new C1421e(d));
        }

        void m5276b(String str, int i) {
            m5271a(str, new C1418b(i));
        }

        void m5278b(String str, boolean z) {
            m5271a(str, z ? ADCData.f2166a : ADCData.f2167b);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCData.h */
    static class C1424h extends C0670i {
        C1424h() {
        }

        boolean m5290a() {
            return true;
        }

        String m5291b() {
            return SchemaSymbols.ATTVAL_TRUE;
        }

        double m5292d() {
            return 1.0d;
        }

        int m5293e() {
            return 1;
        }

        boolean m5294l() {
            return true;
        }

        void m5289a(ae aeVar) {
            aeVar.m2514a(SchemaSymbols.ATTVAL_TRUE);
        }
    }

    static {
        f2166a = new C1424h();
        f2167b = new C1417a();
        f2168c = new C1420d();
    }

    public static void main(String[] args) {
        System.out.println("==== ADCData Test ====");
        C1423g c1423g = new C1423g();
        c1423g.m5276b("one", 1);
        c1423g.m5275b("pi", 3.14d);
        c1423g.m5277b("name", "\"Abe Pralle\"");
        c1423g.m5271a(SchemaSymbols.ATTVAL_LIST, new C1419c());
        c1423g.m5271a("subtable", new C1423g());
        c1423g.m5274b("subtable").m5276b("five", 5);
        System.out.println("LIST:" + c1423g.m5279c(SchemaSymbols.ATTVAL_LIST));
        c1423g.m5279c(SchemaSymbols.ATTVAL_LIST).m5231a(3);
        System.out.println(c1423g);
        System.out.println(c1423g.m5283g("one"));
        System.out.println(c1423g.m5282f("one"));
        System.out.println(c1423g.m5283g("pi"));
        System.out.println(c1423g.m5282f("pi"));
        System.out.println(c1423g.m5281e("name"));
        System.out.println(c1423g.m5282f("name"));
        System.out.println(c1423g.m5283g("name"));
        System.out.println(c1423g.m5279c(SchemaSymbols.ATTVAL_LIST));
        System.out.println(c1423g.m5279c("list2"));
        System.out.println(c1423g.m5279c("subtable"));
        System.out.println(c1423g.m5274b("subtable"));
        System.out.println(c1423g.m5274b("subtable2"));
        System.out.println(c1423g.m5274b(SchemaSymbols.ATTVAL_LIST));
    }
}
