package exceptions;

public class InvalidForTheDayException extends Exception {
    public InvalidForTheDayException(String errorMessage) {
        super(errorMessage);
    }
}
