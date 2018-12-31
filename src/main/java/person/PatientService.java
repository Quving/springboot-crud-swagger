package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void getPatient(String uuid) {
        patientRepository.findById(uuid);
    }

    public void updatePatient(String id, Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(String uuid) {
        patientRepository.deleteById(uuid);
    }
}
