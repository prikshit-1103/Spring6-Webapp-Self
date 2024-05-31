package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.services.AuthorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorsService authorsService;

    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors",authorsService.findAll());
        return "authors";
    }
}
