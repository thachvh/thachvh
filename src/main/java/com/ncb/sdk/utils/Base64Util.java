package com.ncb.sdk.utils;
import java.util.Base64;

public class Base64Util {
    // Method to encode a string to Base64
    public static String encode(String text) {
        byte[] bytesToEncode = text.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytesToEncode);
        return new String(encodedBytes);
    }

    // Method to decode a Base64 string
    public static String decode(String encodedText) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String originalText = "Hello, World!";
        String encodedText = encode(originalText);
        System.out.println("Encoded text: " + encodedText);
        String decodedText = decode(encodedText);
        System.out.println("Decoded text: " + decodedText);
    }
}
