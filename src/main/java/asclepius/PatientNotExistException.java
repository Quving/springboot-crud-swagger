package asclepius;

public class PatientNotExistException extends Exception {
    public PatientNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
