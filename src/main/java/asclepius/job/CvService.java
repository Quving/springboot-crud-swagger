package asclepius.job;

import asclepius.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CvService {

    @Autowired
    CvRepository cvRepository;
    @Autowired
    CompanyRepository companyRepository;

    public List<Cv> getAllCv() {
        return cvRepository.findAll();
    }

    public void addCv(Cv cv) {
        cvRepository.save(cv);
    }

    public Optional<Cv> getCv(UUID uuid) {
        return cvRepository.findById(uuid);
    }

    public void updateJob(UUID id, Cv cv) {
        cvRepository.save(cv);
    }

    public void deleteJob(UUID uuid) {
        cvRepository.deleteById(uuid);
    }

    public void addCompanyToJob(UUID cv_id, UUID company_id) {
        if (companyRepository.existsById(company_id)) {
            Cv cv = getCv(cv_id).get();
            cv.addCompany(company_id);
            updateJob(cv_id, cv);
        }
    }

    public void removeNurseFromMedicalfile(UUID cv_id, UUID company_id) {
        if (companyRepository.existsById(company_id)) {
            Cv cv = getCv(cv_id).get();
            cv.removeCompany(company_id);
            updateJob(cv_id, cv);
        }
    }
}
