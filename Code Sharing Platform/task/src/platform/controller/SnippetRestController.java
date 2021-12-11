package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import platform.dto.SnippetDto;
import platform.mapper.SnippetMapper;
import platform.model.Snippet;
import platform.service.SnippetService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SnippetRestController {

    private final SnippetService snippetService;
    private final SnippetMapper snippetMapper;

    public SnippetRestController(@Autowired SnippetService snippetService, SnippetMapper snippetMapper) {
        this.snippetService = snippetService;
        this.snippetMapper = snippetMapper;
    }

    @GetMapping(value = "/api/code/latest", produces = "application/json")
    public ResponseEntity<List<SnippetDto>> findLatest() {
        return new ResponseEntity<>(this.snippetService.findLatest(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/code/{uuid}")
    public ResponseEntity<SnippetDto> findById(@PathVariable String uuid) {

        Optional<Snippet> opt = this.snippetService.findById(uuid);

        if (opt.isPresent()) {
            SnippetDto snippetDto = snippetMapper.snippetToSnippetDto(opt.get());
            return new ResponseEntity<>(snippetDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    public ResponseEntity<Map<String, String>> postSnippet(@RequestBody SnippetDto snippetDto) {
        Map<String, String> result = this.snippetService.saveCodeSnippetDto(snippetDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
