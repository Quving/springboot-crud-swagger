package asclepius;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patient extends Person {
    public Patient(String name) {
        super(name);
    }

    public String toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type", _type);
        jo.put("name", _name);
        jo.put("uuid", _uuid);
        jo.put("location", _location.toJson());

        return jo.toString();
    }

    public static Patient fromJson(String json) {
        JSONObject jo = new JSONObject(json);
        Patient patient = new Patient(jo.getString("name"));
        patient.setLocation(Location.fromJson(jo.getString("location")));

        return patient;
    }
}
