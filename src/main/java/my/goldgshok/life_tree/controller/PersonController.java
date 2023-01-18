package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("web/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "create")
    public String create(@ModelAttribute("personDto") PersonDto personDto) {
        var person = PersonConverter.convert(personDto);
        personService.create(person);
        return "success";
    }

    @PostMapping(value = "update")
    public void update(@RequestBody PersonDto request) {
        var person = PersonConverter.convert(request);
        personService.update(person);
    }

    @PostMapping(value = "get-by-id")
    public PersonDto getById(@RequestBody RequestById request) {
        var personId = request.getId();
        var person = personService.getById(personId);
        return PersonConverter.convert(person);
    }

    @GetMapping(value = "/create-form")
    public String createForm(Model model) {
        model.addAttribute("personDto", new PersonDto());
        return "create-form";
    }

}
