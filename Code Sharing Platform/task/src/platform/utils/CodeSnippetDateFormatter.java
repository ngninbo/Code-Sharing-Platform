package platform.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeSnippetDateFormatter {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return formatter.format(date);
    }
}
