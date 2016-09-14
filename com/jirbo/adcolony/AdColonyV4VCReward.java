package com.jirbo.adcolony;

public class AdColonyV4VCReward {
    boolean f2331a;
    String f2332b;
    int f2333c;

    AdColonyV4VCReward(boolean success, String name, int amount) {
        this.f2331a = success;
        this.f2332b = name;
        this.f2333c = amount;
    }

    public boolean success() {
        return this.f2331a;
    }

    public String name() {
        return this.f2332b;
    }

    public int amount() {
        return this.f2333c;
    }

    public String toString() {
        if (this.f2331a) {
            return this.f2332b + ":" + this.f2333c;
        }
        return "no reward";
    }
}
