package person;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.DBCollectionUpdateOptions;
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

    public Nurse getNurse(UUID uuid) throws NurseNotExistException {
        Nurse nurse = null;
        BasicDBObject query = new BasicDBObject("uuid", uuid.toString());
        nurse = Nurse.fromJson(MongoManager.getInstance().getNurseCollection().findOne(query).toString());

        if (nurse == null) {
            throw new NurseNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return nurse;
        }
    }

    public Patient getPatient(UUID uuid) throws PatientNotExistException {
        Patient patient = null;
        BasicDBObject query = new BasicDBObject("uuid", uuid.toString());
        patient = Patient.fromJson(MongoManager.getInstance().getPatientCollection().findOne(query).toString());

        if (patient == null) {
            throw new PatientNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return patient;
        }
    }

    public void addNurse(Nurse nurse) {
        BasicDBObject update = BasicDBObject.parse(nurse.toJson());
        BasicDBObject query = new BasicDBObject("uuid", nurse.getUuid().toString());
        DBCollectionUpdateOptions options = new DBCollectionUpdateOptions().upsert(true);
        MongoManager.getInstance().getNurseCollection().update(query, update, options);
    }

    public void addPatient(Patient patient) {
        BasicDBObject update = BasicDBObject.parse(patient.toJson());
        BasicDBObject query = new BasicDBObject("uuid", patient.getUuid().toString());
        DBCollectionUpdateOptions options = new DBCollectionUpdateOptions().upsert(true);
        MongoManager.getInstance().getPatientCollection().update(query, update, options);
    }

    public int countNurse(BasicDBObject query) {
        return (int) MongoManager.getInstance().getNurseCollection().count(query);
    }

    public int countPatient(BasicDBObject query) {
        return (int) MongoManager.getInstance().getPatientCollection().count(query);
    }

    public void deletePatient(UUID uuid) {

    }

    public void deleteNurse(UUID uuid) {
    }
}
