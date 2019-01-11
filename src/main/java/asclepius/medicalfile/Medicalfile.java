package asclepius.medicalfile;

import asclepius.MongoDocument;
import asclepius.patient.Patient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "medicalfiles")
public class Medicalfile extends MongoDocument {
    private UUID nurseId;
    private List<UUID> patientIds;

    public Medicalfile(UUID nurseId) {
        this.nurseId = nurseId;
        patientIds = new ArrayList<>();
    }


    public UUID getNurseUuid() {
        return nurseId;
    }

    public void setNurseUuid(UUID nurse_uuid) {
        this.nurseId = nurse_uuid;
    }

    public List<UUID> getPatientIds() {
        return patientIds;
    }

    public void setPatientIds(List<UUID> patientIds) {
        this.patientIds = patientIds;
    }

    public void addPatient(Patient patient) {
        patientIds.add(patient.getUuid());
    }

    public void addPatient(UUID uuid) {
        patientIds.add(uuid);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
