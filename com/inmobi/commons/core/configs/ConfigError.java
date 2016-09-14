package com.inmobi.commons.core.configs;

class ConfigError {
    private ErrorCode f1560a;
    private String f1561b;

    public enum ErrorCode {
        NETWORK_ERROR,
        CONFIG_SERVER_INTERNAL_ERROR,
        PARSING_ERROR
    }

    public ConfigError(ErrorCode errorCode, String str) {
        this.f1560a = errorCode;
        this.f1561b = str;
    }

    public ErrorCode m1633a() {
        return this.f1560a;
    }

    public String m1634b() {
        return this.f1561b;
    }
}
