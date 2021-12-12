package platform.dto;

import platform.model.Snippet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DTO class of Snippet
 */
public class SnippetDto {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    private String code;
    private String date;
    private Long time;
    private Long views;

    public SnippetDto() {
    }

    public SnippetDto(String code, LocalDateTime date) {
        this();
        this.code = code;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        this.date = formatter.format(date);
    }

    public SnippetDto(String code, LocalDateTime date, Long time, Long views) {
        this(code, date);
        this.time = time;
        this.views = views;
    }

    public SnippetDto(Snippet snippet) {
        this(snippet.getCode(), snippet.getDate(), snippet.getTime(), snippet.getViews());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
