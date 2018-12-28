package person;

import exception.NurseAlreadyExistsException;
import exception.NurseNotExistException;
import exception.PatientAlreadyExistsException;
import exception.PatientNotExistException;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonManagerTest {

    @Test
    public void getPatient() {
        UUID uuid1 = UUID.fromString("44ff17a3-1d91-4382-803e-80db767fcdd3");
        Patient patient = new Patient("Patient1");
        patient.setUuid(uuid1);

        try {
            PersonManager.getInstance().addPatient(patient);
            patient.equals(PersonManager.getInstance().getPatient(uuid1));
        } catch (PatientAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PatientNotExistException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = PatientAlreadyExistsException.class)
    public void addPatient() throws PatientAlreadyExistsException {
        UUID uuid1 = UUID.fromString("866f74aa-0472-40d8-99b0-799391a06e3b");
        UUID uuid2 = UUID.fromString("44ff17a3-1d91-4382-803e-80db767fcdd3");
        "".length();
        // Add patient 1
        Patient patient1 = new Patient("Patient1");
        patient1.setUuid(uuid1);
        assertFalse(PersonManager.getInstance().patientExists(patient1.getUuid()));
        PersonManager.getInstance().addPatient(patient1);
        assertTrue(PersonManager.getInstance().patientExists(patient1.getUuid()));
        PersonManager.getInstance().addPatient(patient1);
    }

    @Test
    public void deletePatient() {
    }

    @Test
    public void getNurse() {
        UUID uuid1 = UUID.fromString("44ff17a3-1d91-4382-803e-80db767fcdd3");
        Nurse nurse = new Nurse("Nurse1");
        nurse.setUuid(uuid1);

        try {
            PersonManager.getInstance().addNurse(nurse);
            nurse.equals(PersonManager.getInstance().getNurse(uuid1));
        } catch (NurseAlreadyExistsException e) {
            e.printStackTrace();
        } catch (NurseNotExistException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NurseAlreadyExistsException.class)
    public void addNurse() throws NurseAlreadyExistsException {
        UUID uuid1 = UUID.fromString("866f74aa-0472-40d8-99b0-799391a06e3b");
        Nurse nurse = new Nurse("Patient1");
        nurse.setUuid(uuid1);
        assertFalse(PersonManager.getInstance().nurseExists(nurse.getUuid()));
        PersonManager.getInstance().addNurse(nurse);
        assertTrue(PersonManager.getInstance().nurseExists(nurse.getUuid()));
        PersonManager.getInstance().addNurse(nurse);
    }

    @Test
    public void deleteNurse() {
    }
}