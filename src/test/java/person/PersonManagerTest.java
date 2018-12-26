package person;

import com.mongodb.BasicDBObject;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PersonManagerTest {

    @Test
    public void getPatient() {
    }

    @Test
    public void addPatient() {
        UUID uuid1 = UUID.fromString("866f74aa-0472-40d8-99b0-799391a06e3b");
        UUID uuid2 = UUID.fromString("44ff17a3-1d91-4382-803e-80db767fcdd3");


        // Add patient 1
        Patient patient1 = new Patient("Patient1");
        patient1.setUuid(uuid1);
        PersonManager.getInstance().addPatient(patient1);
        int count = PersonManager.getInstance().countPatient(new BasicDBObject("uuid", uuid1.toString()));
        assertEquals(1, count);

        // Add patient 2 with same uuid as patient1.
        Patient patient2 = new Patient("Patient2");
        patient2.setUuid(uuid1);
        PersonManager.getInstance().addPatient(patient2);
        count = PersonManager.getInstance().countPatient(new BasicDBObject("uuid", uuid1.toString()));
        assertEquals(1, count);

        // Add patient 3 with different id.
        Patient patient3 = new Patient("Patient3");
        patient3.setUuid(uuid2);
        PersonManager.getInstance().addPatient(patient3);

        count = PersonManager.getInstance().countPatient(new BasicDBObject("uuid", uuid1.toString()));
        assertEquals(1, count);
        count = PersonManager.getInstance().countPatient(new BasicDBObject("uuid", uuid2.toString()));
        assertEquals(1, count);
    }

    @Test
    public void deletePatient() {
    }

    @Test
    public void getNurse() {
    }

    @Test
    public void addNurse() {
    }

    @Test
    public void deleteNurse() {
    }
}