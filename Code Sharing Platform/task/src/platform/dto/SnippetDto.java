package platform.dto;

import platform.utils.CodeSnippetDateFormatter;

import java.time.LocalDateTime;

/**
 * DTO class of Snippet
 */
@SuppressWarnings({"unused"})
public class SnippetDto {

    private String code;
    private String date;
    private Long time;
    private Long views;

    public SnippetDto() {
    }

    public SnippetDto(String code, LocalDateTime date) {
        this();
        this.code = code;
        this.date = CodeSnippetDateFormatter.formatDate(date);
    }

    public SnippetDto(String code, LocalDateTime date, Long time, Long views) {
        this(code, date);
        this.time = time;
        this.views = views;
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
