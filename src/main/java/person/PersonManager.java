package person;

import exception.NurseNotExistException;
import exception.PatientNotExistException;

import java.util.HashSet;
import java.util.UUID;

public class PersonManager {
    private static PersonManager instance;
    private HashSet<Nurse> _nurses;
    private HashSet<Patient> _patients;

    private PersonManager() {
        _nurses = new HashSet<Nurse>();
        _patients = new HashSet<Patient>();
    }

    public static PersonManager getInstance() {
        if (PersonManager.instance == null) {
            PersonManager.instance = new PersonManager();
        }
        return PersonManager.instance;
    }

    public Patient getPatient(UUID uuid) throws PatientNotExistException {
        for (Patient patient : _patients) {
            if (patient.getUuid().equals(uuid))
                return patient;
        }
        throw new PatientNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
    }

    public void addPatient(Patient patient) {
        if (!_patients.contains(patient)) {
            _patients.add(patient);
        }
    }

    public void deletePatient(UUID uuid) {
        for (Patient nurse : _patients) {
            if (nurse.getUuid().equals(uuid))
                _nurses.remove(nurse);
        }
    }

    public Nurse getNurse(UUID uuid) throws NurseNotExistException {
        for (Nurse nurse : _nurses) {
            if (nurse.getUuid().equals(uuid))
                return nurse;
        }
        throw new NurseNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
    }

    public void addNurse(Nurse nurse) {
        if (!_nurses.contains(nurse)) {
            _nurses.add(nurse);
        }
    }

    public void deleteNurse(UUID uuid) {
        for (Nurse nurse : _nurses) {
            if (nurse.getUuid().equals(uuid))
                _nurses.remove(nurse);
        }
    }
}
