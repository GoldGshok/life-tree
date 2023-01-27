package my.goldgshok.life_tree.service;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.dao.IPersonMapper;
import my.goldgshok.life_tree.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final IPersonMapper personMapper;

    public void create(Person person) {
        person.setId(UUID.randomUUID());
        personMapper.upsert(person);
    }

    public void update(Person person) {
        personMapper.upsert(person);
    }

    public Person getById(UUID personId) {
        return personMapper.getById(personId);
    }

    public List<Person> getJournal(JournalFilterDto filterDto) {
        return personMapper.getJournal(filterDto);
    }

    public Integer getMaxAvailableRows(JournalFilterDto request) {
        return personMapper.getMaxAvailableRows(request);
    }
}
