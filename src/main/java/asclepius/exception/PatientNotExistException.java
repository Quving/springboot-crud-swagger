package asclepius.exception;

public class PatientNotExistException extends Exception {
    public PatientNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
