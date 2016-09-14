package com.startapp.android.publish.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: StartAppSDK */
final class DefaultDateTypeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final DateFormat enUsFormat;
    private final DateFormat iso8601Format;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(String datePattern) {
        this(new SimpleDateFormat(datePattern, Locale.US), new SimpleDateFormat(datePattern));
    }

    public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
        this(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US), DateFormat.getDateTimeInstance(dateStyle, timeStyle));
    }

    DefaultDateTypeAdapter(DateFormat enUsFormat, DateFormat localFormat) {
        this.enUsFormat = enUsFormat;
        this.localFormat = localFormat;
        this.iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement jsonPrimitive;
        synchronized (this.localFormat) {
            jsonPrimitive = new JsonPrimitive(this.enUsFormat.format(src));
        }
        return jsonPrimitive;
    }

    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        if (json instanceof JsonPrimitive) {
            Date deserializeToDate = deserializeToDate(json);
            if (typeOfT == Date.class) {
                return deserializeToDate;
            }
            if (typeOfT == Timestamp.class) {
                return new Timestamp(deserializeToDate.getTime());
            }
            if (typeOfT == java.sql.Date.class) {
                return new java.sql.Date(deserializeToDate.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + typeOfT);
        }
        throw new JsonParseException("The date should be a string value");
    }

    private Date deserializeToDate(JsonElement json) {
        Date parse;
        synchronized (this.localFormat) {
            try {
                parse = this.localFormat.parse(json.getAsString());
            } catch (ParseException e) {
                try {
                    parse = this.enUsFormat.parse(json.getAsString());
                } catch (ParseException e2) {
                    try {
                        parse = this.iso8601Format.parse(json.getAsString());
                    } catch (Throwable e3) {
                        throw new JsonSyntaxException(json.getAsString(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DefaultDateTypeAdapter.class.getSimpleName());
        stringBuilder.append('(').append(this.localFormat.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
