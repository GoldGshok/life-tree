package my.goldgshok.life_tree.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private UUID id;
    private String name;
    private String patronymic;
    private String surname;
    private String lastSurname;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private UUID motherId;
    private UUID fatherId;
    private String about;

}
