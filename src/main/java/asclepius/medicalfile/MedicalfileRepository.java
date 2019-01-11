package asclepius.medicalfile;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MedicalfileRepository extends MongoRepository<Medicalfile, UUID> {

}

