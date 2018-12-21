package person;

import java.util.HashSet;

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

    
}
