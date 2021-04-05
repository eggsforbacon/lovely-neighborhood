package exceptions;

public class InvalidForTheDayException extends RuntimeException {
    public InvalidForTheDayException(String errorMessage) {
        super(errorMessage);
    }
}
