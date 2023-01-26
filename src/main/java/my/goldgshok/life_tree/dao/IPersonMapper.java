package my.goldgshok.life_tree.dao;

import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface IPersonMapper {

    void upsert(Person person);

    Person getById(@Param("personId") UUID personId);

    List<Person> getJournal(@Param("filter") JournalFilterDto filter);
}
