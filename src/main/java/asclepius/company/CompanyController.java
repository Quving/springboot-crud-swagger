package asclepius.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService _companyService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCompany(@RequestBody Company company) {
        _companyService.addCompany(company);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Company getCompany(@PathVariable String id) {
        return _companyService.getNurse(UUID.fromString(id)).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteCompany(@PathVariable String id) {
        _companyService.deleteCompany(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateCompany(@RequestBody Company person, @PathVariable String id) {
        _companyService.updateCompany(UUID.fromString(id), person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Company> getAllCompany() {
        return _companyService.getAllCompany();
    }
}
