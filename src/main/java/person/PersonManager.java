package person;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.DBCollectionUpdateOptions;
import com.mongodb.client.model.UpdateOptions;
import exception.NurseAlreadyExistsException;
import exception.NurseNotExistException;
import exception.PatientAlreadyExistsException;
import exception.PatientNotExistException;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

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
        Document doc = (Document) MongoManager.getInstance().getNurseCollection().find(query).first();
        nurse = Nurse.fromJson(doc.toJson());
        if (nurse == null) {
            throw new NurseNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return nurse;
        }
    }

    public Patient getPatient(UUID uuid) throws PatientNotExistException {
        Patient patient = null;
        BasicDBObject query = new BasicDBObject("uuid", uuid.toString());
        Document doc = (Document) MongoManager.getInstance().getPatientCollection().find(query).first();
        patient = Patient.fromJson(doc.toJson());
        if (patient == null) {
            throw new PatientNotExistException(String.format("Nurse %s does not exist", uuid.toString()));
        } else {
            return patient;
        }
    }

    public void addNurse(Nurse nurse) throws NurseAlreadyExistsException {
        Bson update = Document.parse(nurse.toJson());
        if (!nurseExists(nurse.getUuid()))
            MongoManager.getInstance().getNurseCollection().insertOne(update);
        else
            throw new NurseAlreadyExistsException(String.format("Patient %s already exists.", nurse.getUuid().toString()));
    }

    public boolean nurseExists(UUID uuid) {
        Bson query = new BasicDBObject("uuid", uuid.toString());
        FindIterable doc = MongoManager.getInstance().getNurseCollection().find(query);
        return doc.first() != null;
    }

    public boolean patientExists(UUID uuid) {
        Bson query = new BasicDBObject("uuid", uuid.toString());
        FindIterable doc = MongoManager.getInstance().getPatientCollection().find(query);
        return doc.first() != null;
    }

    public void addPatient(Patient patient) throws PatientAlreadyExistsException {
        Bson update = Document.parse(patient.toJson());
        if (!patientExists(patient.getUuid()))
            MongoManager.getInstance().getPatientCollection().insertOne(update);
        else
            throw new PatientAlreadyExistsException(String.format("Patient %s already exists.", patient.getUuid().toString()));
    }

    public void deletePatient(UUID uuid) {

    }

    public void deleteNurse(UUID uuid) {
    }
}
