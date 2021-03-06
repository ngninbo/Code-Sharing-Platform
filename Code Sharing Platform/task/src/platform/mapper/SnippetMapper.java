package platform.mapper;

import org.springframework.stereotype.Component;
import platform.dto.SnippetDto;
import platform.model.Snippet;
import platform.utils.SnippetDtoFromSnippet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class can be used for conversion between Snippet and SnippetDto and vice versa
 * @author Beauclair Dongmo Ngnintedem
 */
@Component
public class SnippetMapper {

    public SnippetDto snippetToSnippetDto(Snippet snippet) {
        return new SnippetDtoFromSnippet(snippet);
    }

    /**
     * Convert SnippetDto to Snippet
     * @param snippetDto Snippet DTO
     * @return Snippet
     */
    public Snippet snippetDtoToSnippet(SnippetDto snippetDto) {
        return new Snippet(snippetDto);
    }

    /**
     * Convert list of snippet to a list of snippet DTOs
     * @param snippets List of Snippet
     * @return List of Snippet DTO
     */
    public List<SnippetDto> snippetsToListSnippetDto(List<Snippet> snippets) {
        return snippets.stream().map(SnippetDtoFromSnippet::new).collect(Collectors.toList());
    }
}
