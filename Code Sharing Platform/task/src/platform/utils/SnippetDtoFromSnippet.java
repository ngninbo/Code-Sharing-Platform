package platform.utils;

import platform.dto.SnippetDto;
import platform.model.Snippet;

/**
 * Create DTO from snippet object
 * @see Snippet
 * @author Beauclair Dongmo Ngnintedem
 */
public class SnippetDtoFromSnippet extends SnippetDto {

    /**
     * Map Snippet object to DTO
     * @param snippet Snippet object
     */
    public SnippetDtoFromSnippet(Snippet snippet) {
        super(snippet.getCode(), snippet.getDate(), snippet.getTime(), snippet.getViews());
    }
}
