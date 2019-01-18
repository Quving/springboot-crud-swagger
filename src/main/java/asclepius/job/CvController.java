package asclepius.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/job")
public class CvController {
    private Logger logger = LoggerFactory.getLogger(CvController.class);
    @Autowired
    private CvService cvService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCv(@RequestBody Cv job) {
        cvService.addCv(job);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{cv_id}/add/company/{company_id}")
    public void addCompanyToCv(@PathVariable String cv_id, @PathVariable String company_id) {
        cvService.addCompanyToJob(UUID.fromString(cv_id), UUID.fromString(company_id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{cv_id}/remove/company/{company_id}")
    public void removeCompanyFromCv(@PathVariable String cv_id, @PathVariable String company_id) {
        cvService.removeNurseFromMedicalfile(UUID.fromString(cv_id), UUID.fromString(company_id));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Cv getCv(@PathVariable String id) {
        return cvService.getCv(UUID.fromString(id)).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteCv(@PathVariable String id) {
        cvService.deleteJob(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateCv(@RequestBody Cv job, @PathVariable String id) {
        cvService.updateJob(UUID.fromString(id), job);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Cv> getAllCv() {
        return cvService.getAllCv();
    }
}
