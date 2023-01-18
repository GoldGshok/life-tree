package my.goldgshok.life_tree.dao;

import my.goldgshok.life_tree.SpringBootBaseTest;
import my.goldgshok.life_tree.model.Gender;
import my.goldgshok.life_tree.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IPersonMapperTest extends SpringBootBaseTest {

    @Autowired
    private IPersonMapper personMapper;

    @Test
    void upsert_createNew_success() {
        var person = getBaseModel();
        assertDoesNotThrow(() -> personMapper.upsert(person));
    }

    @Test
    void upsert_updateExist_success() {
        var person = getBaseModel();
        assertDoesNotThrow(() -> personMapper.upsert(person));

        person.setAbout("I like world!");
        person.setDeathday(LocalDate.now());
        person.setFatherId(UUID.randomUUID());
        person.setMotherId(UUID.randomUUID());
        person.setGender(Gender.FEMALE);

        assertDoesNotThrow(() -> personMapper.upsert(person));
    }

    @Test
    void getById_getValidModel() {
        var person = getBaseModel();
        person.setAbout("I like world!");
        person.setDeathday(LocalDate.now());
        person.setFatherId(UUID.randomUUID());
        person.setMotherId(UUID.randomUUID());
        personMapper.upsert(person);

        var actualPerson = personMapper.getById(person.getId());

        assertEquals(person, actualPerson);
    }

    private Person getBaseModel() {
        var person = new Person();
        person.setId(UUID.randomUUID());
        person.setName("Name");
        person.setPatronymic("Patronymic");
        person.setSurname("Surname");
        person.setBirthday(LocalDate.now());
        person.setGender(Gender.MALE);
        return person;
    }
}