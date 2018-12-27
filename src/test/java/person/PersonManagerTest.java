package person;

import com.mongodb.BasicDBObject;
import exception.PatientAlreadyExistsException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.junit.Assert.*;

public class PersonManagerTest {
    @Test
    public void getPatient() {
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
    }

    @Test
    public void addNurse() {
        UUID uuid1 = UUID.fromString("866f74aa-0472-40d8-99b0-799391a06e3b");
        UUID uuid2 = UUID.fromString("44ff17a3-1d91-4382-803e-80db767fcdd3");

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