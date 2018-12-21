package exception;

public class NurseNotExistException extends Exception {
    public NurseNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
