package asclepius;

public class PatientAlreadyExistsException extends Exception {
    public PatientAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
