package my.goldgshok.life_tree.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Траспорт с определенными ключами для библиотеки go.js genogram (менять название ключей нельзя)")
public class GenogramDto {

    @Schema(description = "Ключ человека для ")
    private UUID key;

    @Schema(description = "Полное имя человека")
    private String n;

    @Schema(description = "День рождения")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

    @Schema(description = "День смерти")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String deathday;

    @Schema(description = "Пол человека (M/F)")
    private String s;

    @Schema(description = "ID мамы")
    private String m;

    @Schema(description = "ID папы")
    private String f;

    @Schema(description = "ID жены")
    private String ux;

    @Schema(description = "ID мужа")
    private String vir;

    @Schema(description = "Дополнительные атрибуты человека")
    private List<String> a;

}
