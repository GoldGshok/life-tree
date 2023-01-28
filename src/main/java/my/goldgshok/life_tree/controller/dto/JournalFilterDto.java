package my.goldgshok.life_tree.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Запрос для отображения журнала")
public class JournalFilterDto {

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Фамилия")
    private String surname;

    @Schema(description = "Предыдущая фамилия (если есть)")
    private String lastSurname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Schema(description = "День смерти")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deathday;

    @Schema(description = "Пол человека (муж/жен)")
    private Integer genderId;

    @Schema(description = "Пол человека (муж/жен)")
    private Integer limit;

    @Schema(description = "Смещение выборки")
    private Integer offset;
}
