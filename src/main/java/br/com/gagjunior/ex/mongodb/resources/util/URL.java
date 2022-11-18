package br.com.gagjunior.ex.mongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, StandardCharsets.UTF_8);
        } catch (RuntimeException e) {
            return "";
        }
    }
}
