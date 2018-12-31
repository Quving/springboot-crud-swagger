package person;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PatientRepository extends MongoRepository<Patient, String> {

}

