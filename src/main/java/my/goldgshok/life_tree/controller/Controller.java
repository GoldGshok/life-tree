package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.request.PersonRequest;
import my.goldgshok.life_tree.controller.request.RequestById;
import my.goldgshok.life_tree.controller.response.PersonResponse;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("web/person")
public class Controller {

    private final PersonService personService;

    @PostMapping(value = "create")
    public void create(@RequestBody PersonRequest request) {
        var person = PersonConverter.convert(request);
        personService.create(person);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody PersonRequest request) {
        var person = PersonConverter.convert(request);
        personService.update(person);
    }

    @PostMapping(value = "get-by-id")
    public PersonResponse update(@RequestBody RequestById request) {
        var personId = request.getId();
        var person = personService.getById(personId);
        return PersonConverter.convert(person);
    }

}
