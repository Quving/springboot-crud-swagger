package asclepius.job;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CvRepository extends MongoRepository<Cv, UUID> {

}

