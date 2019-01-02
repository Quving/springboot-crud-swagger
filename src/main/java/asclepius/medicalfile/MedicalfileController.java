package asclepius.medicalfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalfile")
public class MedicalfileController {
    @Autowired
    private MedicalfileService _medicalfileService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addMedicalfile(@RequestBody Medicalfile person) {
        _medicalfileService.addMedicalfile(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public void getMedicalfile(@PathVariable String uuid) {
        _medicalfileService.getMedicalfile(uuid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteMedicalfile(String uuid) {
        _medicalfileService.deleteMedicalfile(uuid);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateMedicalfile(@RequestBody Medicalfile person, @PathVariable String id) {
        _medicalfileService.updateMedicalfile(id, person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Medicalfile> getAllMedicalfile() {
        return _medicalfileService.getAllMedicalfile();
    }
}
