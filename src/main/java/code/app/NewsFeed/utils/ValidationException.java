package code.app.NewsFeed.utils;

import java.util.Collections;
import java.util.List;

public class ValidationException extends RuntimeException {
    private List<String> validationErrors;

    public ValidationException(List<String> validationMessages) {
        super("Validation Failed");
        this.validationErrors = validationMessages;
    }

    public ValidationException(String message) {
        this(Collections.singletonList(message));
    }

    public List<String> getValidationError() {
        return validationErrors;
    }
}
