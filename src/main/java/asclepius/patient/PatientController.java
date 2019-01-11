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
    public void getPatient(@PathVariable UUID uuid) {
        _patientService.getPatient(uuid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deletePatient(@PathVariable UUID uuid) {
        _patientService.deletePatient(uuid);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updatePatient(@RequestBody Patient person, @PathVariable UUID uuid) {
        _patientService.updatePatient(uuid, person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Patient> getAllPatients() {
        return _patientService.getAllPatients();
    }
}
