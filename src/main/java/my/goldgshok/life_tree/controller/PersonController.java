package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.controller.validation.RequestValidator;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("web/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "create")
    public String create(@ModelAttribute("personDto") PersonDto request) {
        RequestValidator.validateCreate(request);
        var person = PersonConverter.convert(request);
        personService.create(person);
        return "success";
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
    public List<PersonDto> getJournal(@RequestBody JournalFilterDto request) {
        RequestValidator.validate(request);
        var persons = personService.getJournal(request);
        return persons.stream()
                .map(PersonConverter::convert)
                .toList();
    }

    @GetMapping(value = "create-form")
    public String createForm(Model model) {
        model.addAttribute("personDto", new PersonDto());
        return "create-form";
    }

    @GetMapping({"/journal"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("journal");
        var filter = JournalFilterDto.builder()
                .limit(10)
                .offset(0)
                .build();
        mav.addObject("persons", getJournal(filter));
        return mav;
    }

}
