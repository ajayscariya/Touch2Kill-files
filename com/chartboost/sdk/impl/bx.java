package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.io.Writer;

public class bx extends Writer implements Serializable {
    private final StringBuilder f1080a;

    public bx() {
        this.f1080a = new StringBuilder();
    }

    public bx(int i) {
        this.f1080a = new StringBuilder(i);
    }

    public Writer append(char value) {
        this.f1080a.append(value);
        return this;
    }

    public Writer append(CharSequence value) {
        this.f1080a.append(value);
        return this;
    }

    public Writer append(CharSequence value, int start, int end) {
        this.f1080a.append(value, start, end);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(String value) {
        if (value != null) {
            this.f1080a.append(value);
        }
    }

    public void write(char[] value, int offset, int length) {
        if (value != null) {
            this.f1080a.append(value, offset, length);
        }
    }

    public String toString() {
        return this.f1080a.toString();
    }
}
