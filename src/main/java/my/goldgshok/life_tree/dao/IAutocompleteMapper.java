package my.goldgshok.life_tree.dao;

import my.goldgshok.life_tree.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAutocompleteMapper {

    List<Person> getPersonsByFullName(@Param("name") String fullName,
            @Param("patronymic") String patronymic,
            @Param("surname") String surname);
}
