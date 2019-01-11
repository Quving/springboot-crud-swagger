package asclepius.medicalfile;

import asclepius.MongoDocument;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "medicalfiles")
public class Medicalfile extends MongoDocument {
    private UUID patientId;
    private List<UUID> nurses;

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public List<UUID> getNurses() {
        return nurses;
    }

    public void setNurses(List<UUID> nurses) {
        this.nurses = nurses;
    }

    public void addNurse(UUID uuid) {
        if (!nurses.contains(uuid))
            nurses.add(uuid);
    }

    public void removeNurse(UUID uuid) {
        if (nurses.contains(uuid))
            nurses.remove(uuid);
    }
}
