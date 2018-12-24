package person;

import exception.NurseNotExistException;
import exception.PatientNotExistException;

import java.util.UUID;

public class PersonManager {
    private static PersonManager instance;

    public static PersonManager getInstance() {
        if (PersonManager.instance == null) {
            PersonManager.instance = new PersonManager();
        }
        return PersonManager.instance;
    }

    public Patient getPatient(UUID uuid) throws PatientNotExistException {
        Patient patient = null;

        if (patient == null) {
            throw new PatientNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return patient;
        }

    }

    public void addPatient(Patient patient) {
    }

    public void deletePatient(UUID uuid) {
    }

    public Nurse getNurse(UUID uuid) throws NurseNotExistException {
        Nurse nurse = null;

        if (nurse == null) {
            throw new NurseNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return nurse;
        }
    }

    public void addNurse(Nurse nurse) {
    }

    public void deleteNurse(UUID uuid) {
    }
}
