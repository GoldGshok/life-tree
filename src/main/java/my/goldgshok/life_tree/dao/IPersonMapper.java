package my.goldgshok.life_tree.dao;

import my.goldgshok.life_tree.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
public interface IPersonMapper {

    void upsert(Person person);

    Person getById(@Param("personId") UUID personId);
}
