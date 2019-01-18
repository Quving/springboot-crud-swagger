package asclepius.nurse;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface NurseRepository extends MongoRepository<Nurse, UUID> {

}

