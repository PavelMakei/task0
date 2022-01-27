package by.makei.array.exception;

public class IncorrectCustomArrayException extends Exception{

    public IncorrectCustomArrayException() {
    }

    public IncorrectCustomArrayException(String message) {
        super(message);
    }

    public IncorrectCustomArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCustomArrayException(Throwable cause) {
        super(cause);
    }
}
