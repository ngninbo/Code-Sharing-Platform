package platform.mapper;

import org.springframework.stereotype.Component;
import platform.dto.SnippetDto;
import platform.model.Snippet;

import java.util.LinkedList;
import java.util.List;


@Component
public class SnippetMapper {

    public SnippetDto snippetToSnippetDto(Snippet snippet) {
        return new SnippetDto(snippet);
    }

    public Snippet snippetDtoToSnippet(SnippetDto snippetDto) {
        return new Snippet(snippetDto);
    }

    public List<SnippetDto> snippetsToListSnippetDto(List<Snippet> snippets) {
        List<SnippetDto> list = new LinkedList<>();

        if (snippets != null) {
            snippets.forEach(snippet -> list.add(new SnippetDto(snippet)));
            return list;
        }
        else {
            return List.of();
        }
    }
}
