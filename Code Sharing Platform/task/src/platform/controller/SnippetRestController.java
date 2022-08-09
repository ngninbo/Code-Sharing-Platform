package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import platform.dto.SnippetDto;
import platform.mapper.SnippetMapper;
import platform.model.Snippet;
import platform.service.SnippetService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class provides endpoints for requests of snippet via REST API
 * @author Beauclair Dongmo Ngnintedem
 */
@RestController
@RequestMapping(value = "/api/code")
@SuppressWarnings({"unused"})
public class SnippetRestController {

    private final SnippetService snippetService;
    private final SnippetMapper snippetMapper;

    @Autowired
    public SnippetRestController(SnippetService snippetService, SnippetMapper snippetMapper) {
        this.snippetService = snippetService;
        this.snippetMapper = snippetMapper;
    }

    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SnippetDto>> findLatest() {
        return new ResponseEntity<>(this.snippetService.findLatest(), HttpStatus.OK);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<SnippetDto> findById(@PathVariable String uuid) {

        Optional<Snippet> opt = this.snippetService.findById(uuid);

        if (opt.isPresent()) {
            SnippetDto snippetDto = snippetMapper.mapToSnippetDto(opt.get());
            return new ResponseEntity<>(snippetDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> postSnippet(@RequestBody SnippetDto snippetDto) {
        Map<String, String> result = this.snippetService.saveCodeSnippetDto(snippetDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
