package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AutocompleteController {

    @PostMapping("get-persons-by-full-name")
    public void getPersonsByFullName(Object request) {

    }

    @GetMapping
    public void getGenders() {

    }
}
