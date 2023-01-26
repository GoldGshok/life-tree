package my.goldgshok.life_tree.controller.validation;

import lombok.experimental.UtilityClass;
import my.goldgshok.life_tree.controller.dto.JournalFilterDto;
import my.goldgshok.life_tree.controller.dto.PersonDto;
import my.goldgshok.life_tree.controller.dto.RequestById;
import my.goldgshok.life_tree.exception.ValidateException;

@UtilityClass
public class RequestValidator {

    private final String ERROR_MESSAGE_CODE = "field_is_wrong_or_null";

    public void validate(JournalFilterDto request) {
        if (request.getLimit() == null || request.getLimit() <= 0) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "limit");
        }
        if (request.getOffset() == null || request.getOffset() < 0) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "offset");
        }
    }

    public void validate(RequestById request) {
        if (request.getId() == null) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "id");
        }
    }

    public void validateCreate(PersonDto request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "name");
        }
        if (request.getPatronymic() == null || request.getPatronymic().isBlank()) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "patronymic");
        }
        if (request.getSurname() == null || request.getSurname().isBlank()) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "surname");
        }
        if (request.getBirthday() == null) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "birthday");
        }
        if (request.getGenderId() == null) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "gender");
        }
    }

    public void validateUpdate(PersonDto request) {
        if (request.getId() == null) {
            throw new ValidateException(ERROR_MESSAGE_CODE, "id");
        }
        validateCreate(request);
    }

}
