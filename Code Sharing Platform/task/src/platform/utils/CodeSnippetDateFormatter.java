package platform.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeSnippetDateFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    /**
     * Convert LocalDatetime to yyyy-MM-dd HH:mm:ss format
     * @param date LocalDateTime
     * @return Formatted datetime in String format
     */
    public static String formatDate(LocalDateTime date) {
        return FORMATTER.format(date);
    }
}
