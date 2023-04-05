package my.goldgshok.life_tree.controller.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalResponse <T> {

    @ArraySchema(schema = @Schema(description = "Данные журнала"))
    private List<T> items;
    @Schema(description = "Количество найденных строк")
    private Integer foundRows;
    @Schema(description = "Количество доступных записей по переданному фильтру")
    private Integer maxAvailableRows;

}
