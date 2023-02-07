package my.goldgshok.life_tree.converter;

import lombok.experimental.UtilityClass;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.model.Gender;
import my.goldgshok.life_tree.model.Person;

@UtilityClass
public class PersonConverter {

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
        personDto.setFatherFullName(person.getFatherFullName());
        personDto.setMotherId(person.getMotherId());
        personDto.setMotherFullName(person.getMotherFullName());
        personDto.setAbout(person.getAbout());
        return personDto;
    }

}
