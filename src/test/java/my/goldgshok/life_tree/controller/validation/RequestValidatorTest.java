package my.goldgshok.life_tree.controller.validation;

import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.exception.ValidateException;
import my.goldgshok.life_tree.model.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RequestValidatorTest {

    @Test
    void validate_byId_success() {
        var request = new RequestById();
        assertThrows(ValidateException.class, () -> RequestValidator.validate(request));
    }

    @ParameterizedTest
    @MethodSource("getFilters")
    void validate_byFilter_success(JournalFilterDto request) {
        assertThrows(ValidateException.class, () -> RequestValidator.validate(request));
    }

    @ParameterizedTest
    @MethodSource("getPersonRequests")
    void validateCreate_baseCases_success(PersonDto request) {
        assertThrows(ValidateException.class, () -> RequestValidator.validateCreate(request));
    }

    @Test
    void validateUpdate_baseCase_success() {
        var request = new PersonDto();
        assertThrows(ValidateException.class, () -> RequestValidator.validateUpdate(request));
    }

    private static Stream<Arguments> getPersonRequests() {
        return Stream.of(Arguments.of(new PersonDto()),
                Arguments.of(getPersonDto().name(null).build()),
                Arguments.of(getPersonDto().patronymic(null).build()),
                Arguments.of(getPersonDto().surname(null).build()),
                Arguments.of(getPersonDto().birthday(null).build()),
                Arguments.of(getPersonDto().genderId(null).build()));
    }

    private static Stream<Arguments> getFilters() {
        return Stream.of(Arguments.of(new JournalFilterDto()),
                Arguments.of(JournalFilterDto.builder().limit(10).build()));
    }

    private static PersonDto.PersonDtoBuilder getPersonDto() {
        return PersonDto.builder()
                .name("name")
                .patronymic("patronymic")
                .surname("surname")
                .birthday(LocalDate.now())
                .genderId(Gender.MALE.getId());
    }
}