package com.applovin.impl.sdk;

class cv implements Runnable {
    final /* synthetic */ cr f313a;
    private final String f314b;
    private final bw f315c;
    private final cs f316d;

    cv(cr crVar, bw bwVar, cs csVar) {
        this.f313a = crVar;
        this.f314b = bwVar.m154a();
        this.f315c = bwVar;
        this.f316d = csVar;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C0237n.m248a();
            if (this.f313a.f301a.m4166e()) {
                this.f313a.f302b.m309i(this.f314b, "Task re-scheduled...");
                this.f313a.m234a(this.f315c, this.f316d, 2000);
            } else if (this.f313a.f301a.isEnabled()) {
                this.f313a.f302b.m309i(this.f314b, "Task started execution...");
                this.f315c.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (this.f315c instanceof dh) {
                    dh dhVar = (dh) this.f315c;
                    dc.m236a().m238a(dhVar.m242e(), currentTimeMillis2, C0240q.m268a(this.f313a.f301a), dhVar.m243f());
                }
                this.f313a.f302b.m309i(this.f314b, "Task executed successfully in " + currentTimeMillis2 + "ms.");
                cc b = this.f313a.f301a.m4163b();
                b.m216a(this.f314b + "_count");
                b.m217a(this.f314b + "_time", currentTimeMillis2);
            } else {
                if (this.f313a.f301a.m4167f()) {
                    this.f313a.f301a.m4168g();
                } else {
                    this.f313a.f302b.m310w(this.f314b, "Task not executed, SDK is disabled");
                }
                this.f315c.m155b();
            }
        } catch (Throwable th) {
            this.f313a.f302b.m308e(this.f314b, "Task failed execution in " + (System.currentTimeMillis() - currentTimeMillis) + "ms.", th);
        }
    }
}
