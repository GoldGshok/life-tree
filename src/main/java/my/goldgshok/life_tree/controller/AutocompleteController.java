package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.JournalResponse;
import my.goldgshok.life_tree.controller.dto.NameAutocompleteDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.AutocompleteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("web/autocomplete")
@CrossOrigin(origins = "http://localhost:3000")
public class AutocompleteController {

    private final AutocompleteService autocompleteService;

    @PostMapping("get-persons-by-full-name")
    public JournalResponse<PersonDto> getPersonsByFullName(@RequestBody NameAutocompleteDto request) {
        var persons = autocompleteService.getPersonsByFullName(request.getName(),
                request.getPatronymic(),
                request.getSurname(),
                request.getGenderId());
        var personsDto = persons.stream()
                .map(PersonConverter::convert)
                .toList();
        return new JournalResponse<>(personsDto, personsDto.size(), personsDto.size());
    }

}
