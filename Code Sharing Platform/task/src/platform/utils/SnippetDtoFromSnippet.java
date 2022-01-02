package platform.utils;

import platform.dto.SnippetDto;
import platform.model.Snippet;

public class SnippetDtoFromSnippet extends SnippetDto {

    public SnippetDtoFromSnippet(Snippet snippet) {
        super(snippet.getCode(), snippet.getDate(), snippet.getTime(), snippet.getViews());
    }
}
