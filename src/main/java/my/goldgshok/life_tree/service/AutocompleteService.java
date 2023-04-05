package my.goldgshok.life_tree.service;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.dao.IAutocompleteMapper;
import my.goldgshok.life_tree.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutocompleteService {

    private final IAutocompleteMapper autocompleteMapper;

    public List<Person> getPersonsByFullName(String name, String patronymic, String surname, Integer genderId) {
        return autocompleteMapper.getPersonsByFullName(name, patronymic, surname, genderId);
    }
}
