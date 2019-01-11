package asclepius.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(UUID uuid) {
        return patientRepository.findById(uuid);
    }

    public void updatePatient(UUID id, Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(UUID uuid) {
        patientRepository.deleteById(uuid);
    }
}
