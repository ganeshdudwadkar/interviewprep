package leetcode.medium;

// https://leetcode.com/problems/encode-and-decode-tinyurl/

/*
535. Encode and Decode TinyURL

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
decoded to the original URL.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EncodeDecodeTinyurl {

    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final Map<String, String> shortToLongMap = new ConcurrentHashMap<>();
    private static final Map<String, String> longToShortMap = new ConcurrentHashMap<>();
    private static int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShortMap.containsKey(longUrl))
            return longToShortMap.get(longUrl);

        String shortUrl = BASE_HOST + convertDecimalToBase62(counter++);
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private String convertDecimalToBase62(int n) {
        final char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(6);
        sb.append("aaaaaa"); // stubbed - what if this gets actually generated?
        int index = 0;
        while (n > 0) {
            sb.deleteCharAt(index);
            sb.insert(index++, BASE62[n % 62]);
            n /= 62;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EncodeDecodeTinyurl obj = new EncodeDecodeTinyurl();
        System.out.println(obj.encode("testurl"));
    }
}