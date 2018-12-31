package asclepius;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patient extends Person {
    public Patient(String name) {
        super(name);
    }
}
