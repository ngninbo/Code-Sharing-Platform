package platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import platform.dto.SnippetDto;
import platform.utils.CodeSnippetDateFormatter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * JPA Entity storing all information about code snippet
 * @author Beauclair Dongmo Ngnintedem
 */
@Entity
public class Snippet {

    @Id
    private String id = UUID.randomUUID().toString();
    @Lob
    private String code;
    @CreationTimestamp
    private LocalDateTime date;

    @Column(columnDefinition = "boolean default false")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean timeRestricted;

    @Column(columnDefinition = "boolean default false")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean viewRestricted;

    @Column(columnDefinition = "boolean default false")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean secret;

    @JsonIgnore
    private Long time;
    @JsonIgnore
    private Long views;

    public Snippet() {
    }

    public Snippet(String code, Long time, Long views) {
        this.code = code;
        this.date = LocalDateTime.now();
        this.time = time;
        this.views = views;
    }

    public Snippet(SnippetDto dto) {
        this(dto.getCode(), dto.getTime(), dto.getViews());
        this.timeRestricted = dto.getTime() > 0;
        this.viewRestricted = dto.getViews() > 0;
        this.secret = this.isTimeRestricted() || this.isViewRestricted();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isTimeRestricted() {
        return timeRestricted;
    }

    public void setTimeRestricted(boolean timeRestricted) {
        this.timeRestricted = timeRestricted;
    }

    public boolean isViewRestricted() {
        return viewRestricted;
    }

    public void setViewRestricted(boolean viewRestricted) {
        this.viewRestricted = viewRestricted;
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

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    @Transactional
    public synchronized void updateTime(long time) {
        this.time = time;
    }

    @Transactional
    public synchronized void decrementViews() {
        long remainingViews = this.views - 1;
        this.views = remainingViews < 0 ? 0 : remainingViews;
    }

    public String formatDate() {
        return CodeSnippetDateFormatter.formatDate(date);
    }
}
