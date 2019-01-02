package asclepius.medicalfile;

import asclepius.patient.Patient;
import asclepius.util.Helper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "medicalfiles")
public class Medicalfile {
    @Id
    private String uuid;
    private String nurseId;
    private List<String> patientIds;

    public Medicalfile() {
        uuid = UUID.randomUUID().toString();
        nurseId = "";
        patientIds = new ArrayList<>();
    }


    public String getNurseUuid() {
        return nurseId;
    }

    public void setNurseUuid(String nurse_uuid) {
        this.nurseId = nurse_uuid;
    }

    public List<String> getPatientIds() {
        return patientIds;
    }

    public void setPatientIds(List<String> patientIds) {
        this.patientIds = patientIds;
    }

    public void addPatient(Patient patient) {
        patientIds.add(patient.getUuid());
    }

    public void addPatient(String uuid) {
        if (Helper.isUUID(uuid))
            patientIds.add(uuid);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
