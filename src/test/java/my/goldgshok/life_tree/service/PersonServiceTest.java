package my.goldgshok.life_tree.service;

import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.dao.IPersonMapper;
import my.goldgshok.life_tree.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private IPersonMapper personMapper;
    @InjectMocks
    private PersonService personService;

    @Test
    void create() {
        var person = new Person();

        personService.create(person);

        assertNotNull(person.getId());
        verify(personMapper).upsert(person);
    }

    @Test
    void update() {
        var person = new Person();

        personService.update(person);

        verify(personMapper).upsert(person);
    }

    @Test
    void getById() {
        var person = new Person();
        person.setId(UUID.randomUUID());
        when(personMapper.getById(person.getId())).thenReturn(person);

        var actualPerson = personService.getById(person.getId());

        assertEquals(person, actualPerson);
    }

    @Test
    void getJournal() {
        when(personMapper.getJournal(any())).thenReturn(Collections.emptyList());

        var journal = personService.getJournal(new JournalFilterDto());

        Assertions.assertTrue(journal.isEmpty());
        verify(personMapper).getJournal(any());
    }
}