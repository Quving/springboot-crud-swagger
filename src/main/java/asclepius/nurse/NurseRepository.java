package asclepius.nurse;

import asclepius.nurse.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface NurseRepository extends MongoRepository<Nurse, UUID> {

}

