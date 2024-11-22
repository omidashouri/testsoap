package ir.omidashouri.testsoap.exception;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("Cannot divide by zero");
    }

    public DivideByZeroException(String message) {
        super(message);
    }

    public DivideByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideByZeroException(Throwable cause) {
        super(cause);
    }
}
