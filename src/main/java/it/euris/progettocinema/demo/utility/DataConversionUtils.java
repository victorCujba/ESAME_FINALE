package it.euris.progettocinema.demo.utility;

import it.euris.progettocinema.demo.data.enums.MovieType;

import java.time.LocalDateTime;

public class DataConversionUtils {

    public static String numberToString(Number value) {
        return value == null ? null : value.toString();
    }

    public static Long stringToLong(String value) {
        return value == null ? null : Long.parseLong(value);
    }

    public static Integer stringToInteger(String value) {
        return value == null ? null : Integer.parseInt(value);
    }

    public static LocalDateTime stringToLocalDateTime(String value) {
        return value == null ? null : LocalDateTime.parse(value.substring(0, 19));
    }

    public static String localDateTimeToString(LocalDateTime value) {
        return value == null ? null : value.toString();
    }


    public static String movieTypeToString(MovieType value) {
        return value == null ? null : value.toString();
    }

    public static MovieType stringToMovieType(String value) {
        return value == null ? null : MovieType.valueOf(value.toUpperCase());
    }
}
