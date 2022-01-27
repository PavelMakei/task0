package by.makei.array.exception;

public class IncorrectCustomArrayInsertException extends Exception{

    public IncorrectCustomArrayInsertException(){}

    public IncorrectCustomArrayInsertException(String message, Throwable cause){
        super(message,cause);
    }

    public IncorrectCustomArrayInsertException(String message){
        super(message);
    }

    public IncorrectCustomArrayInsertException(Throwable cause){
        super(cause);
    }
}
