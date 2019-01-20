package asclepius.job;

import asclepius.MongoDocument;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "cvs")
public class Cv extends MongoDocument {
    private UUID employeeId;
    private List<UUID> companies;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public List<UUID> getCompanies() {
        return companies;
    }

    public void setCompany(List<UUID> company) {
        this.companies = company;
    }

    public void addCompany(UUID uuid) {
        if (!companies.contains(uuid))
            companies.add(uuid);
    }

    public void removeCompany(UUID uuid) {
        if (companies.contains(uuid))
            companies.remove(uuid);
    }
}
