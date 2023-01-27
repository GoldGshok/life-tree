package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.controller.dto.JournalResponse;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.controller.validation.RequestValidator;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("web/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "create")
    public void create(@RequestBody PersonDto request) {
        RequestValidator.validateCreate(request);
        var person = PersonConverter.convert(request);
        personService.create(person);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody PersonDto request) {
        RequestValidator.validateUpdate(request);
        var person = PersonConverter.convert(request);
        personService.update(person);
    }

    @PostMapping(value = "get-by-id")
    public PersonDto getById(@RequestBody RequestById request) {
        RequestValidator.validate(request);
        var personId = request.getId();
        var person = personService.getById(personId);
        return PersonConverter.convert(person);
    }

    @PostMapping(value = "get-journal")
    public JournalResponse<PersonDto> getJournal(@RequestBody JournalFilterDto request) {
        RequestValidator.validate(request);
        var persons = personService.getJournal(request);
        var maxAvailableRows = personService.getMaxAvailableRows(request);
        var personsDto = persons.stream()
                .map(PersonConverter::convert)
                .toList();
        return new JournalResponse<>(personsDto, personsDto.size(), maxAvailableRows);
    }

}
