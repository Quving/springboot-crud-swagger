package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService _patientService;
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addPatient(@RequestBody Patient person) {
        _patientService.addPatient(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public void getPatient(@PathVariable String uuid) {
        _patientService.getPatient(uuid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deletePatient(String uuid) {
        _patientService.deletePatient(uuid);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updatePatient(@RequestBody Patient person, @PathVariable String id) {
        _patientService.updatePatient(id, person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Patient> getAllPatients() {
        return _patientService.getAllPatients();
    }
}
