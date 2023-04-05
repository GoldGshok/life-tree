package my.goldgshok.life_tree.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE(1, "муж"),
    FEMALE(2, "жен");

    private final Integer id;
    private final String name;

    private static final Map<Integer, Gender> VALUES_BY_ID = new HashMap<>();

    static {
        for (Gender item : values()) {
            VALUES_BY_ID.put(item.getId(), item);
        }
    }

    public static Gender getById(Integer id) {
        return VALUES_BY_ID.get(id);
    }

}
