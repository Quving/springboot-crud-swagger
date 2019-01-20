package asclepius.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmployerRepository extends MongoRepository<Employee, UUID> {

}

