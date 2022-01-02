package platform.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeSnippetDateFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static String formatDate(LocalDateTime date) {
        return FORMATTER.format(date);
    }
}
