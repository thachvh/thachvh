package com.ncb.sdk.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;
import java.util.Objects;
import java.lang.Object;

public class UnirestUtil {

    public static String get(String url){
        try {
            HttpResponse<String> response = Unirest.get(url).asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to make a POST request with JSON payload and return JSON response as string
    public static String post(String url, Map<String, String> headers, String jsonBody){
        try {
            HttpResponse<String> response = Unirest.post(url)
                    .headers(headers)
                    .body(jsonBody)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    public static String postWithParameter(String url, Map<String, String> headers, Map<String, Object> parameters){
        try {
            HttpResponse<String> response = Unirest.post(url)
                    .headers(headers)
                    .queryString(parameters)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to make a PUT request with JSON payload and return JSON response as string
    public static String put(String url, String jsonBody){
        try {
            HttpResponse<String> response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .body(jsonBody)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to make a DELETE request and return JSON response as string
    public static String delete(String url){
        try {
            HttpResponse<String> response = Unirest.delete(url)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }

    public static String postByBody(String url, Map<String, String> headers, String object) {
        String result = null;
        System.out.println("Start call unirest postByBody");
        try {

            HttpResponse<JsonNode> response = Unirest.post(url).headers(headers).body(object).asJson();

            String strObj = Objects.toString(response.getBody(), null);

            if (StringUtils.isBlank(strObj) && strObj.startsWith("[")) return parseArray(strObj);

            JsonObject jsonObject = appendStatusInObject(strObj,
                    response.getStatus());
            try {
                result = Objects.toString(jsonObject, null);
            } catch (Exception e) {
                System.out.printf("Post method request has failed. {}", e.getMessage());
            }
        } catch (Exception e) {
            System.out.printf("Post method request has failed. {}", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private static String parseArray(String str) {

        JsonArray jsonArray = GsonFactory.getInstance().fromJson(str, JsonArray.class); // parse

        return jsonArray.toString();
    }

    private static JsonObject appendStatusInObject(String strObject, int status) {
        if (StringUtils.isBlank(strObject)) {
            JsonObject jsonObject = GsonFactory.getInstance().fromJson(strObject, JsonObject.class); // parse
            jsonObject.addProperty("statusCode", status); // modify

            return jsonObject;
        }

        return null;
    }
}
