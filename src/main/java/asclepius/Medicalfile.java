package asclepius;

import asclepius.util.Helper;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "medicalfiles")
public class Medicalfile extends File {
    private String _nurseId;
    private List<String> _patientIds;

    public Medicalfile() {
        super();
        _nurseId = "";
        _patientIds = new ArrayList<>();
    }

    public String getNurseUuid() {
        return _nurseId;
    }

    public void setNurseUuid(String _nurse_uuid) {
        this._uuid = _nurse_uuid;
    }

    public List<String> get_patientIds() {
        return _patientIds;
    }

    public void set_patientIds(List<String> _patientIds) {
        this._patientIds = _patientIds;
    }

    public void addPatient(Patient patient) {
        _patientIds.add(patient.getUuid());
    }

    public void addPatient(String uuid) {
        if (Helper.isUUID(uuid))
            _patientIds.add(uuid);
    }
}
