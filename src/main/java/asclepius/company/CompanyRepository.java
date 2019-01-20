package asclepius.company;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CompanyRepository extends MongoRepository<Company, UUID> {

}

