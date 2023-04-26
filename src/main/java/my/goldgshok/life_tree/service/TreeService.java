package my.goldgshok.life_tree.service;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.dao.IPersonMapper;
import my.goldgshok.life_tree.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreeService {

    private final IPersonMapper personMapper;

    public List<Person> getAllPersons() {
        return personMapper.getAllPerson();
    }
}
