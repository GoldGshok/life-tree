package my.goldgshok.life_tree.converter;

import my.goldgshok.life_tree.controller.request.PersonRequest;
import lombok.experimental.UtilityClass;
import my.goldgshok.life_tree.controller.response.PersonResponse;
import my.goldgshok.life_tree.model.Person;

@UtilityClass
public class PersonConverter {

    public Person convert(PersonRequest request) {
        var person = new Person();
        person.setId(request.getId());
        person.setName(request.getName());
        person.setPatronymic(request.getPatronymic());
        person.setSurname(request.getSurname());
        person.setBirthday(request.getBirthday());
        person.setDeathday(request.getDeathday());
        person.setFatherId(request.getFatherId());
        person.setMotherId(request.getMotherId());
        person.setAbout(request.getAbout());
        return person;
    }

    public PersonResponse convert(Person person) {
        var personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setPatronymic(person.getPatronymic());
        personResponse.setSurname(person.getSurname());
        personResponse.setBirthday(person.getBirthday());
        personResponse.setDeathday(person.getDeathday());
        personResponse.setFatherId(person.getFatherId());
        personResponse.setMotherId(person.getMotherId());
        personResponse.setAbout(person.getAbout());
        return personResponse;
    }
}
