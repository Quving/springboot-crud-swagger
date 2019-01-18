package asclepius.medicalfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/medicalfile")
public class MedicalfileController {
    private Logger logger = LoggerFactory.getLogger(MedicalfileController.class);
    @Autowired
    private MedicalfileService medicalfileService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addMedicalfile(@RequestBody Medicalfile medicalfile) {
        medicalfileService.addMedicalfile(medicalfile);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{medicalfile_id}/add/nurse/{nurse_id}")
    public void addNurseToMedicalfile(@PathVariable String medicalfile_id, @PathVariable String nurse_id) {
        medicalfileService.addNurseToMedicalfile(UUID.fromString(medicalfile_id), UUID.fromString(nurse_id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{medicalfile_id}/remove/nurse/{nurse_id}")
    public void removeNurseFromMedicalfile(@PathVariable String medicalfile_id, @PathVariable String nurse_id) {
        medicalfileService.removeNurseFromMedicalfile(UUID.fromString(medicalfile_id), UUID.fromString(nurse_id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Medicalfile getMedicalfile(@PathVariable String id) {
        return medicalfileService.getMedicalfile(UUID.fromString(id)).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteMedicalfile(@PathVariable String id) {
        medicalfileService.deleteMedicalfile(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateMedicalfile(@RequestBody Medicalfile medicalfile, @PathVariable String id) {
        medicalfileService.updateMedicalfile(UUID.fromString(id), medicalfile);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Medicalfile> getAllMedicalfile() {
        return medicalfileService.getAllMedicalfile();
    }
}
