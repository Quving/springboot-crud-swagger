package asclepius.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployerService _employerService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addEmployee(@RequestBody Employee employee) {
        _employerService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return _employerService.getEmployee(UUID.fromString(id)).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteEmployee(@PathVariable String id) {
        _employerService.deleteEmployee(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateEmployee(@RequestBody Employee person, @PathVariable String id) {
        _employerService.updateEmployee(UUID.fromString(id), person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Employee> getAllEmployees() {
        return _employerService.getAllEmployees();
    }
}
