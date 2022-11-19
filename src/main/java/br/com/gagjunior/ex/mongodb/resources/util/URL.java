package br.com.gagjunior.ex.mongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, StandardCharsets.UTF_8);
        } catch (RuntimeException e) {
            return "";
        }
    }

    public static LocalDate convertLocalDate(String textDate, LocalDate defaultValue) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd")
                    .withZone(ZoneId.of("GMT"));
            return LocalDate.parse(textDate, fmt);
        } catch (RuntimeException e) {
            return defaultValue;
        }
    }
}
