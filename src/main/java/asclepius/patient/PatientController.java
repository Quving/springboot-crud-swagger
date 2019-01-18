package asclepius.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService _patientService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addPatient(@RequestBody Patient person) {
        _patientService.addPatient(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Patient getPatient(@PathVariable String id) {
        return _patientService.getPatient(UUID.fromString(id)).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deletePatient(@PathVariable String id) {
        _patientService.deletePatient(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updatePatient(@RequestBody Patient person, @PathVariable String id) {
        _patientService.updatePatient(UUID.fromString(id), person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Patient> getAllPatients() {
        return _patientService.getAllPatients();
    }
}
