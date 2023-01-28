package ir.hospital.hospitalmicroservice.exception;

public class Exist extends RuntimeException{
    public Exist() {
    }

    public Exist(String message) {
        super(message);
    }

    public Exist(String message, Throwable cause) {
        super(message, cause);
    }

    public Exist(Throwable cause) {
        super(cause);
    }

    public Exist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
