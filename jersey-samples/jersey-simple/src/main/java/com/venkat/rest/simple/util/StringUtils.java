package com.venkat.rest.simple.util;

import java.util.Optional;
import java.util.function.Function;

public final class StringUtils {

    private StringUtils() { }

    public static enum RegExConverter {
        GLOBAL_EXPR(str -> String.format("(%s)", str)),
        IGNORE_CASE(str -> String.format("i?%s", str)),
        CONTAINS(str -> String.format(".*%s.*", str)),
        CONTAINS_WORD(str -> String.format("(%s)", str.replaceAll("\\s+", "|")));

        private Function<String, String> converter;

        private RegExConverter(Function<String, String> c) {
            this.converter = c;
        }

        public String convert(String str) {
            return str != null ? converter.apply(str) : null;
        }
    }

    public static final String getContainsRegex(String searchTerm, final boolean ignoreCase) {
        return Optional.of(searchTerm)
                   .map(RegExConverter.CONTAINS_WORD::convert)
                   .map(RegExConverter.CONTAINS::convert)
                   .map(termPattern -> ignoreCase ? RegExConverter.IGNORE_CASE.convert(termPattern) : termPattern)
                   .map(RegExConverter.GLOBAL_EXPR::convert)
                   .get();
    }

    public static final String getContainsRegex(String searchTerm) {
        return getContainsRegex(searchTerm, true);
    }

}
