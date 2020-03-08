package dev.growi.hibp.pwnedpasswords.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class IllegalParameterException extends RuntimeException {
    public IllegalParameterException() {
        super();
    }
    public IllegalParameterException(String message, Throwable cause) {
        super(message, cause);
    }
    public IllegalParameterException(String message) {
        super(message);
    }
    public IllegalParameterException(Throwable cause) {
        super(cause);
    }
}