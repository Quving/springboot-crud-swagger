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
    private MedicalfileService _medicalfileService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addMedicalfile(@RequestBody Medicalfile medicalfile) {
        logger.info(medicalfile.getNurseUuid().toString());
        _medicalfileService.addMedicalfile(medicalfile);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Optional<Medicalfile> getMedicalfile(@PathVariable String id) {
        return _medicalfileService.getMedicalfile(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteMedicalfile(@PathVariable String id) {
        _medicalfileService.deleteMedicalfile(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateMedicalfile(@RequestBody Medicalfile medicalfile, @PathVariable String id) {
        _medicalfileService.updateMedicalfile(UUID.fromString(id), medicalfile);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Medicalfile> getAllMedicalfile() {
        return _medicalfileService.getAllMedicalfile();
    }
}
