package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.NameAutocompleteDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.model.Person;
import my.goldgshok.life_tree.service.AutocompleteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("web/autocomplete")
@CrossOrigin(origins = "http://localhost:3000")
public class AutocompleteController {

    private final AutocompleteService autocompleteService;

    @PostMapping("get-persons-by-full-name")
    public List<PersonDto> getPersonsByFullName(NameAutocompleteDto request) {
        var persons = autocompleteService.getPersonsByFullName(request.getName(), request.getPatronymic(), request.getSurname());
        return persons.stream()
                .map(PersonConverter::convert)
                .toList();
    }

}
