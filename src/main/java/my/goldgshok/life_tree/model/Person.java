package my.goldgshok.life_tree.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Person {

    private UUID id;
    private String name;
    private String patronymic;
    private String surname;
    private LocalDate birthday;
    private LocalDate deathday;
    private UUID motherId;
    private UUID fatherId;
    private String about;

}
