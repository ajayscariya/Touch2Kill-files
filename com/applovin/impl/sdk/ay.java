package com.applovin.impl.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class ay {
    private static Object m97a(Object obj) {
        return obj == JSONObject.NULL ? null : obj instanceof JSONObject ? m99a((JSONObject) obj) : obj instanceof JSONArray ? m98a((JSONArray) obj) : obj;
    }

    public static List m98a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m97a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map m99a(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m97a(jSONObject.get(str)).toString());
        }
        return hashMap;
    }

    static JSONObject m100a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }
}
