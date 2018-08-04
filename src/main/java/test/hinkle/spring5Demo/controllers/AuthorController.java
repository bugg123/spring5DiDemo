package test.hinkle.spring5Demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.hinkle.spring5Demo.repositories.AuthorRepository;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository){
    this.authorRepository = authorRepository;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model){

    model.addAttribute("authors", authorRepository.findAll());

    return "authors";
  }
}
