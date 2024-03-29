package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.dto.SnippetDto;
import platform.model.Snippet;
import platform.service.SnippetService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implement a controller for updating models in views
 * @author Beauclair Dongmo Ngnintedem
 */
@Controller
@RequestMapping(value = "/code")
@SuppressWarnings({"unused"})
public class SnippetController {

    private final SnippetService snippetService;

    @Autowired
    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping("/{uuid}")
    public String getSnippet(@PathVariable String uuid, Model model) {
        Snippet snippet = this.snippetService.findById(uuid).orElseThrow();
        model.addAttribute("snippet", snippet);
        return "snippetView";
    }

    @GetMapping("/new")
    public String getSnippet() {
        return "upload";
    }

    @GetMapping("/latest")
    public String findLatest(Model model) {
        List<SnippetDto> snippets = this.snippetService.findLatest();
        model.addAttribute("snippets", snippets);
        return "snippetList";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNotFound(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
