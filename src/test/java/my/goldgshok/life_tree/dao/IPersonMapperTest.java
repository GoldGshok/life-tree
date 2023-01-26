package my.goldgshok.life_tree.dao;

import my.goldgshok.life_tree.SpringBootBaseTest;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.model.Gender;
import my.goldgshok.life_tree.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

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
    void getById_getValidModel_success() {
        var person = getBaseModel();
        person.setAbout("I like world!");
        person.setDeathday(LocalDate.now());
        person.setFatherId(UUID.randomUUID());
        person.setMotherId(UUID.randomUUID());
        personMapper.upsert(person);

        var actualPerson = personMapper.getById(person.getId());

        assertEquals(person, actualPerson);
    }

    @ParameterizedTest
    @MethodSource("getFilterData")
    @Sql(scripts = "/sql/journal.sql")
    void getById_getJournal_success(JournalFilterDto filterDto, int countRows) {
        filterDto.setLimit(10);
        filterDto.setOffset(0);
        var journal = personMapper.getJournal(filterDto);

        assertEquals(countRows, journal.size());
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

    private static Stream<Arguments> getFilterData() {
        return Stream.of(Arguments.of(
                JournalFilterDto.builder()
                        .name("Пет")
                        .build(), 1),
                Arguments.of(JournalFilterDto.builder()
                        .patronymic("Анатол")
                        .build(), 1),
                Arguments.of(JournalFilterDto.builder()
                        .surname("Петр")
                        .build(), 2),
                Arguments.of(JournalFilterDto.builder()
                        .lastSurname("Иван")
                        .build(), 1),
                Arguments.of(JournalFilterDto.builder()
                        .birthday(LocalDate.of(2002, 1, 1))
                        .build(), 1),
                Arguments.of(JournalFilterDto.builder()
                        .deathday(LocalDate.of(2000, 1, 1))
                        .build(), 1),
                Arguments.of(JournalFilterDto.builder()
                        .genderId(Gender.MALE.getId())
                        .build(), 2)
        );
    }
}