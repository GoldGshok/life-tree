package my.goldgshok.life_tree.exception;

import lombok.Getter;

@Getter
public class ValidateException extends RuntimeException {

    private final String errorCode;
    private final transient Object[] args;

    public ValidateException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }
}
