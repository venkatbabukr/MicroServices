package com.venkat.rest.simple.util;

import java.util.Optional;
import java.util.function.Function;

public final class StringUtils {

    private StringUtils() { }

    public static enum RegExMapper {
        GLOBAL_EXPR(str -> String.format("(%s)", str)),
        IGNORE_CASE(str -> String.format("i?%s", str)),
        CONTAINS(str -> String.format(".*%s.*", str)),
        CONTAINS_WORD(str -> String.format("(%s)", str.replaceAll("\\s+", "|")));

        private Function<String, String> mapper;

        private RegExMapper(Function<String, String> m) {
            this.mapper = m;
        }

        public String map(String str) {
            return str != null ? mapper.apply(str) : null;
        }
    }

    public static final String getContainsRegex(String searchTerm, final boolean ignoreCase) {
        return Optional.of(searchTerm)
                   .map(RegExMapper.CONTAINS_WORD::map)
                   .map(RegExMapper.CONTAINS::map)
                   .map(termPattern -> ignoreCase ? RegExMapper.IGNORE_CASE.map(termPattern) : termPattern)
                   .map(RegExMapper.GLOBAL_EXPR::map)
                   .get();
    }

    public static final String getContainsRegex(String searchTerm) {
        return getContainsRegex(searchTerm, true);
    }

}
