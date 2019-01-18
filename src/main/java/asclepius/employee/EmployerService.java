package asclepius.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;

    public List<Employee> getAllEmployees() {
        return employerRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employerRepository.save(employee);
    }

    public Optional<Employee> getEmployee(UUID uuid) {
        return employerRepository.findById(uuid);
    }

    public void updateEmployee(UUID id, Employee employee) {
        employerRepository.save(employee);
    }

    public void deleteEmployee(UUID uuid) {
        employerRepository.deleteById(uuid);
    }
}
