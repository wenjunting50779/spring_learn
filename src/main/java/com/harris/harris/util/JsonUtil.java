package com.harris.harris.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @ClassName JsonUtil
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-10-28 11:24
 **/
public class JsonUtil {
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public JsonUtil() {
    }

    public static <T> String object2String(T object) throws JsonProcessingException {
        if (Objects.isNull(object)) {
            return null;
        } else {
            return object instanceof String ? (String)object : OBJECT_MAPPER.writeValueAsString(object);
        }
    }

    public static <T> String object2StringPretty(T object) throws JsonProcessingException {
        if (Objects.isNull(object)) {
            return null;
        } else {
            return object instanceof String ? (String)object : OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }
    }

    public static <T> T string2Object(String str, Class<T> clazz) throws IOException {
        if (!Objects.isNull(str) && !str.isEmpty() && !Objects.isNull(clazz)) {
            return clazz.equals(String.class) ? (T) str : OBJECT_MAPPER.readValue(str, clazz);
        } else {
            return null;
        }
    }

    public static <T> T string2Object(String str, TypeReference<T> typeReference) throws IOException {
        if (!Objects.isNull(str) && !str.isEmpty() && !Objects.isNull(typeReference)) {
            return typeReference.getType().equals(String.class) ? (T) str : OBJECT_MAPPER.readValue(str, typeReference);
        } else {
            return null;
        }
    }

    public static JsonNode string2JsonNode(String str) throws IOException {
        return !Objects.isNull(str) && !str.isEmpty() ? OBJECT_MAPPER.readTree(str) : null;
    }

    public static <T> String silentObject2String(T object) {
        try {
            return object2String(object);
        } catch (JsonProcessingException var2) {
            logger.error("[ERROR_silentObject2String]object={}", object, var2);
            return null;
        }
    }

    public static <T> String silentObject2StringPretty(T object) {
        try {
            return object2StringPretty(object);
        } catch (JsonProcessingException var2) {
            logger.error("[ERROR_silentObject2StringPretty]object={}", object, var2);
            return null;
        }
    }

    public static <T> T silentString2Object(String str, Class<T> clazz) {
        try {
            return string2Object(str, clazz);
        } catch (Exception var3) {
            logger.error("[ERROR_silentString2Object]str={},clazz={}", new Object[]{str, clazz, var3});
            return null;
        }
    }

    public static <T> T silentString2Object(String str, TypeReference<T> typeReference) {
        try {
            return string2Object(str, typeReference);
        } catch (IOException var3) {
            logger.error("[ERROR_silentString2Object]str={},typeReference={}", new Object[]{str, typeReference, var3});
            return null;
        }
    }

    public static JsonNode silentString2JsonNode(String str) {
        try {
            return string2JsonNode(str);
        } catch (IOException var2) {
            logger.error("[ERROR_silentString2JsonNode]str={}", str, var2);
            return null;
        }
    }

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
