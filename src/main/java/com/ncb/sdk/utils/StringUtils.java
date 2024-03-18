package com.ncb.sdk.utils;

public class StringUtils {

    // Kiểm tra xem chuỗi có rỗng không
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Kiểm tra xem chuỗi có rỗng hoặc chỉ chứa khoảng trắng không
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Đảo ngược một chuỗi
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // Chuyển đổi một chuỗi thành chuỗi viết hoa
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    // Chuyển đổi một chuỗi thành chuỗi viết thường
    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    // Cắt chuỗi thành một mảng các phần tử dựa trên một ký tự phân cách
    public static String[] split(String str, String delimiter) {
        if (str == null) {
            return null;
        }
        return str.split(delimiter);
    }

    // Thay thế tất cả các xuất hiện của một chuỗi con trong chuỗi bằng một chuỗi khác
    public static String replace(String str, String target, String replacement) {
        if (str == null) {
            return null;
        }
        return str.replace(target, replacement);
    }

    // Kiểm tra xem một chuỗi có chứa một chuỗi con hay không
    public static boolean contains(String str, String subStr) {
        if (str == null || subStr == null) {
            return false;
        }
        return str.contains(subStr);
    }

    // Kiểm tra xem một chuỗi có bắt đầu với một chuỗi con cụ thể không
    public static boolean startsWith(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        return str.startsWith(prefix);
    }

    // Kiểm tra xem một chuỗi có kết thúc bằng một chuỗi con cụ thể không
    public static boolean endsWith(String str, String suffix) {
        if (str == null || suffix == null) {
            return false;
        }
        return str.endsWith(suffix);
    }

}
