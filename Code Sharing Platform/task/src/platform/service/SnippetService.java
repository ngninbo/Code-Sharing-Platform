package platform.service;

import platform.dto.SnippetDto;
import platform.model.Snippet;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SnippetService {

    List<SnippetDto> findLatest();
    Map<String, String> saveCodeSnippetDto(SnippetDto snippetDto);
    Optional<Snippet> findById(String id);
    Optional<Snippet> findSecretSnippetById(String uuid);
    void decrementViews(String id);
    void updateTime(long time, String id);

    void deleteById(String uuid);

    void saveSnippet(Snippet snippet);

    Optional<Snippet> findByIdIgnoreRestrictions(String uuid);
}
