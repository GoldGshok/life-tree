package my.goldgshok.life_tree.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @Schema(description = "ID человека")
    private UUID id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Фамилия")
    private String surname;

    @Schema(description = "Предыдущая фамилия (если есть)")
    private String lastSurname;

    @Schema(description = "День рождения")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Schema(description = "День смерти")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deathday;

    @Schema(description = "Пол человека (муж/жен)")
    private Integer genderId;

    @Schema(description = "ID мамы")
    private UUID motherId;

    @Schema(description = "ФИО мамы")
    private String motherFullName;

    @Schema(description = "ID папы")
    private UUID fatherId;

    @Schema(description = "ФИО папы")
    private String fatherFullName;

    @Schema(description = "О человеке")
    private String about;

}
