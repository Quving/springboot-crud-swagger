package asclepius.medicalfile;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalfileRepository extends MongoRepository<Medicalfile, String> {

}
