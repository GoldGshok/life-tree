package my.goldgshok.life_tree.converter;

import lombok.experimental.UtilityClass;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.GenogramDto;
import my.goldgshok.life_tree.model.Gender;
import my.goldgshok.life_tree.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class PersonConverter {

    private final static LocalDate UNKNOWN_DATE = LocalDate.of(1900, 1, 1);

    public Person convert(PersonDto personDto) {
        var person = new Person();
        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setPatronymic(personDto.getPatronymic());
        person.setSurname(personDto.getSurname());
        person.setLastSurname(personDto.getLastSurname());
        person.setBirthday(personDto.getBirthday());
        person.setDeathday(personDto.getDeathday());
        person.setGender(Gender.getById(personDto.getGenderId()));
        person.setFatherId(personDto.getFatherId());
        person.setMotherId(personDto.getMotherId());
        person.setAbout(personDto.getAbout());
        return person;
    }

    public PersonDto convert(Person person) {
        var personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setPatronymic(person.getPatronymic());
        personDto.setSurname(person.getSurname());
        personDto.setLastSurname(person.getLastSurname());
        personDto.setBirthday(person.getBirthday());
        personDto.setDeathday(person.getDeathday());
        personDto.setGenderId(person.getGender().getId());
        personDto.setFatherId(person.getFatherId());
        personDto.setFatherFullName(person.getFatherName());
        personDto.setMotherId(person.getMotherId());
        personDto.setMotherFullName(person.getMotherName());
        personDto.setAbout(person.getAbout());
        return personDto;
    }

    public GenogramDto convertTree(Person person) {
        var treeDto = new GenogramDto();
        treeDto.setKey(person.getId());
        treeDto.setN(String.format("%s %s %s", person.getSurname(), person.getName(), person.getPatronymic()));
        treeDto.setBirthday(convertDate(person.getBirthday()));
        treeDto.setDeathday(convertDate(person.getDeathday()));
        treeDto.setS(convertGender(person.getGender()));
        treeDto.setF(convert(person.getFatherId()));
        treeDto.setM(convert(person.getMotherId()));
        treeDto.setA(List.of(convert(person.getAbout())));
        return treeDto;
    }

    private String convert(Object value) {
        return Optional.ofNullable(value)
                .map(Object::toString)
                .orElse("");
    }

    private String convertDate(LocalDate date) {
        return Optional.ofNullable(date)
                .map(tempDate -> tempDate.equals(UNKNOWN_DATE) ? "?" : tempDate.toString())
                .orElse("");
    }

    private String convertGender(Gender gender) {
        return gender == Gender.MALE ? "M" : "F";
    }

}
