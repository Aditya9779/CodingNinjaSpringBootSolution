package Telecom.SubscriptionService.Exception;

import java.io.Serial;

public class InternalServerError extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    public InternalServerError() {
        super();
    }

    public InternalServerError(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
