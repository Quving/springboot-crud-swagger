package asclepius.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public Optional<Company> getNurse(UUID uuid) {
        return companyRepository.findById(uuid);
    }

    public void updateCompany(UUID id, Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(UUID uuid) {
        companyRepository.deleteById(uuid);
    }
}
