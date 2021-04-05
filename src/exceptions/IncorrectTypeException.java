package exceptions;

public class IncorrectTypeException extends RuntimeException{
    public IncorrectTypeException(String errorMessage) {
        super(errorMessage);
    }
}
