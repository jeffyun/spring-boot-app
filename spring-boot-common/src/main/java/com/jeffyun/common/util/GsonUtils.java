package com.jeffyun.common.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jeff.Wu on 2018/1/10.
 */
public class GsonUtils {
    /**
     * date 转换为long类型
     */
    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .registerTypeAdapter(java.util.Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG)
            .registerTypeAdapter(java.util.Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG)
            .create();


    public static String toJsonString(Object object) {
        return GSON.toJson(object);
    }

    public static final <V> V fromJson(String json, Class<V> type) {
        return GSON.fromJson(json, type);
    }

    public static final <V> V fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        Type type = new TypeToken<ArrayList<Class<T>>>() {
        }.getType();
        return GSON.fromJson(json, type);
    }

    public static <T> Map<String, T> fromJsonToMap(String json, Class<T> clazz) {
        Type type = new TypeToken<Map<String, Class<T>>>() {
        }.getType();
        return GSON.fromJson(json, type);
    }


    /**
     * date to long
     */
    public static class DateSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
    }

    /**
     * long to date
     */
    public static class DateDeserializer implements JsonDeserializer<Date> {
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
        }
    }
}