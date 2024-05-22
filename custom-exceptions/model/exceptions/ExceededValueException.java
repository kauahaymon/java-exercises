package model.exceptions;

public class ExceededValueException extends RuntimeException {

    public ExceededValueException(String msg) {
        super(msg);
    }
}
