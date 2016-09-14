package com.inmobi.commons.core.network;

import com.applovin.sdk.AppLovinErrorCodes;

public class NetworkError {
    private ErrorCode f1594a;
    private String f1595b;

    public enum ErrorCode {
        NETWORK_UNAVAILABLE_ERROR(0),
        UNKNOWN_ERROR(-1),
        NETWORK_IO_ERROR(-2),
        OUT_OF_MEMORY_ERROR(-3),
        INVALID_ENCRYPTED_RESPONSE_RECEIVED(-4),
        RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT(-5),
        HTTP_NO_CONTENT(AppLovinErrorCodes.NO_FILL),
        HTTP_NOT_MODIFIED(304),
        HTTP_BAD_REQUEST(400),
        HTTP_SEE_OTHER(303),
        HTTP_SERVER_NOT_FOUND(404),
        HTTP_MOVED_TEMP(302),
        HTTP_INTERNAL_SERVER_ERROR(500),
        HTTP_NOT_IMPLEMENTED(501),
        HTTP_BAD_GATEWAY(502),
        HTTP_SERVER_NOT_AVAILABLE(503),
        HTTP_GATEWAY_TIMEOUT(504),
        HTTP_VERSION_NOT_SUPPORTED(505);
        
        private int f1593a;

        private ErrorCode(int i) {
            this.f1593a = i;
        }

        public int getValue() {
            return this.f1593a;
        }

        public static ErrorCode fromValue(int i) {
            for (ErrorCode errorCode : values()) {
                if (errorCode.f1593a == i) {
                    return errorCode;
                }
            }
            return null;
        }
    }

    public NetworkError(ErrorCode errorCode, String str) {
        this.f1594a = errorCode;
        this.f1595b = str;
    }

    public ErrorCode m1699a() {
        return this.f1594a;
    }

    public String m1700b() {
        return this.f1595b;
    }
}
