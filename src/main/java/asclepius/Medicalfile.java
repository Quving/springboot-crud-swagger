package asclepius;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicalfiles")
public class Medicalfile extends File {

}
