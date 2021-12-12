package platform.service;

import platform.dto.SnippetDto;
import platform.model.Snippet;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Snippet service. Provides methods for searching and saving snippets
 * @author Beauclair Dongmo Ngnintedem
 */
public interface SnippetService {

    List<SnippetDto> findLatest();
    Map<String, String> saveCodeSnippetDto(SnippetDto snippetDto);
    Optional<Snippet> findById(String id);
    void saveSnippet(Snippet snippet);
}
