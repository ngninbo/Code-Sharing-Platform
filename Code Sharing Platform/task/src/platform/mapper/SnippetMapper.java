package platform.mapper;

import org.springframework.stereotype.Component;
import platform.dto.SnippetDto;
import platform.model.Snippet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class can be used for conversion between Snippet and SnippetDto and vice versa
 * @author Beauclair Dongmo Ngnintedem
 */
@Component
public class SnippetMapper {

    public SnippetDto mapToSnippetDto(Snippet snippet) {
        return new SnippetDto(snippet.getCode(), snippet.getDate(), snippet.getTime(), snippet.getViews());
    }

    /**
     * Convert SnippetDto to Snippet
     * @param snippetDto Snippet DTO
     * @return Snippet
     */
    public Snippet mapToSnippet(SnippetDto snippetDto) {
        return new Snippet(snippetDto.getCode(), snippetDto.getTime(), snippetDto.getViews());
    }

    /**
     * Convert list of snippet to a list of snippet DTOs
     * @param snippets List of Snippet
     * @return List of Snippet DTO
     */
    public List<SnippetDto> mapToListOfSnippetDto(List<Snippet> snippets) {
        return snippets.stream()
                .map(this::mapToSnippetDto)
                .collect(Collectors.toList());
    }
}
