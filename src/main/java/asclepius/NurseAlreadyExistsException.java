package asclepius;

public class NurseAlreadyExistsException extends Exception {
    public NurseAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
