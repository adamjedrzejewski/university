package unique;

public class UniqueException extends Exception {
    public UniqueException() {
    }

    public UniqueException(String message) {
        super(message);
    }

    public UniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueException(Throwable cause) {
        super(cause);
    }

    public UniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
