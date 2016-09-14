package com.chartboost.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import mf.org.w3c.dom.traversal.NodeFilter;

public class ac extends ByteArrayOutputStream {
    private final C0428v f761a;

    public ac(C0428v c0428v, int i) {
        this.f761a = c0428v;
        this.buf = this.f761a.m1149a(Math.max(i, NodeFilter.SHOW_DOCUMENT));
    }

    public void close() throws IOException {
        this.f761a.m1148a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f761a.m1148a(this.buf);
    }

    private void m794a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f761a.m1149a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f761a.m1148a(this.buf);
            this.buf = a;
        }
    }

    public synchronized void write(byte[] buffer, int offset, int len) {
        m794a(len);
        super.write(buffer, offset, len);
    }

    public synchronized void write(int oneByte) {
        m794a(1);
        super.write(oneByte);
    }
}
