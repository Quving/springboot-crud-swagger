package asclepius;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nurses")
public class Nurse extends Person {
    public Nurse(String name) {
        super(name);
    }
}
