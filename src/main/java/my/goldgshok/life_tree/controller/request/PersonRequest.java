package my.goldgshok.life_tree.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PersonRequest {

    @Nullable
    @Schema(description = "ID человека")
    private UUID id;

    @NonNull
    @Schema(description = "Имя")
    private String name;

    @NonNull
    @Schema(description = "Отчество")
    private String patronymic;

    @NonNull
    @Schema(description = "Фамилия")
    private String surname;

    @NonNull
    @Schema(description = "День рождения")
    private LocalDate birthday;

    @Nullable
    @Schema(description = "День смерти")
    private LocalDate deathday;

    @Nullable
    @Schema(description = "ID мамы")
    private UUID motherId;

    @Nullable
    @Schema(description = "ID папы")
    private UUID fatherId;

    @Nullable
    @Schema(description = "О человеке")
    private String about;

}
