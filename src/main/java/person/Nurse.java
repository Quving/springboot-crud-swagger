package person;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nurses")
public class Nurse extends Person {
    public Nurse(String name) {
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

    public static Nurse fromJson(String json) {
        JSONObject jo = new JSONObject(json);
        Nurse nurse = new Nurse(jo.getString("name"));
        nurse.setLocation(Location.fromJson(jo.getString("location")));
        return nurse;
    }
}
