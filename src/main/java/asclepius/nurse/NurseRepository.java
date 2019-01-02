package asclepius.nurse;

import asclepius.nurse.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Nurse, String> {

}

