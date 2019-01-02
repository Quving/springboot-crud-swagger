package asclepius.medicalfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalfile")
public class MedicalfileController {
    private Logger logger = LoggerFactory.getLogger(MedicalfileController.class);
    @Autowired
    private MedicalfileService _medicalfileService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addMedicalfile(@RequestBody Medicalfile medicalfile) {
        logger.info(medicalfile.getNurseUuid());
        _medicalfileService.addMedicalfile(medicalfile);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{uuid}")
    public void getMedicalfile(@PathVariable String uuid) {
        _medicalfileService.getMedicalfile(uuid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteMedicalfile(String uuid) {
        _medicalfileService.deleteMedicalfile(uuid);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateMedicalfile(@RequestBody Medicalfile medicalfile, @PathVariable String id) {
        _medicalfileService.updateMedicalfile(id, medicalfile);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Medicalfile> getAllMedicalfile() {
        return _medicalfileService.getAllMedicalfile();
    }
}
