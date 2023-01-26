package my.goldgshok.life_tree.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import my.goldgshok.life_tree.ControllerTest;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.model.Person;
import my.goldgshok.life_tree.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest extends ControllerTest {

    @MockBean
    private PersonService personService;

    @Test
    void create_baseCase_success() {
        var personRequest = getPersonRequest();
        var content = convertToJson(personRequest);

        var request = MockMvcRequestBuilders.post("/web/person/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content);

        perform(request, status().isOk());

        verify(personService).create(any());
    }

    @Test
    void update_baseCase_success() {
        var personRequest = getPersonRequest();
        var content = convertToJson(personRequest);

        var request = MockMvcRequestBuilders.post("/web/person/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content);

        perform(request, status().isOk());

        verify(personService).update(any());
    }

    @Test
    void getById_baseCase_success() {
        var requestById = new RequestById(UUID.randomUUID());
        var content = convertToJson(requestById);
        var person = Person.builder()
                .id(requestById.getId())
                .name("Name")
                .patronymic("Patronymic")
                .surname("Surname")
                .birthday(LocalDate.now())
                .build();

        when(personService.getById(requestById.getId())).thenReturn(person);

        var request = MockMvcRequestBuilders.post("/web/person/get-by-id")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content);

        var result = perform(request, status().isOk());
        var personResponse = convertToModel(result, new TypeReference<PersonDto>() {});

        verify(personService).getById(requestById.getId());
        assertEquals(person.getId(), personResponse.getId());
        assertEquals(person.getName(), personResponse.getName());
        assertEquals(person.getPatronymic(), personResponse.getPatronymic());
        assertEquals(person.getSurname(), personResponse.getSurname());
        assertEquals(person.getBirthday(), personResponse.getBirthday());
    }

    @Test
    void getJournal_baseCase_success() {
        var filter = JournalFilterDto.builder()
                .limit(10)
                .offset(0)
                .build();
        var content = convertToJson(filter);
        var person = Person.builder()
                .id(UUID.randomUUID())
                .name("Name")
                .patronymic("Patronymic")
                .surname("Surname")
                .birthday(LocalDate.now())
                .build();

        when(personService.getJournal(filter)).thenReturn(List.of(person));

        var request = MockMvcRequestBuilders.post("/web/person/get-journal")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content);

        var result = perform(request, status().isOk());
        var personResponse = convertToModel(result, new TypeReference<List<PersonDto>>() {});

        verify(personService).getJournal(filter);
        var personDto = personResponse.get(0);
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getName(), personDto.getName());
        assertEquals(person.getPatronymic(), personDto.getPatronymic());
        assertEquals(person.getSurname(), personDto.getSurname());
        assertEquals(person.getBirthday(), personDto.getBirthday());
    }

    private PersonDto getPersonRequest() {
        var body = new PersonDto();
        body.setName("name");
        body.setPatronymic("patronymic");
        body.setSurname("surname");
        body.setBirthday(LocalDate.now());
        return body;
    }
}