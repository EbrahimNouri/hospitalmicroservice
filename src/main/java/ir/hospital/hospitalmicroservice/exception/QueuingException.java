package ir.hospital.hospitalmicroservice.exception;

public class QueuingException extends RuntimeException {
    public QueuingException() {
    }

    public QueuingException(String message) {
        super(message);
    }

    public QueuingException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueuingException(Throwable cause) {
        super(cause);
    }

    public QueuingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
