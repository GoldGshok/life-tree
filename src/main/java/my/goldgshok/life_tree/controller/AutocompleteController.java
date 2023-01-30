package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("web/autocomplete")
public class AutocompleteController {

    @PostMapping("get-persons-by-full-name")
    public void getPersonsByFullName(Object request) {

    }

    @GetMapping("get-genders")
    public void getGenders() {

    }
}
