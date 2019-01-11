package asclepius.medicalfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalfileService {

    @Autowired
    MedicalfileRepository medicalfileRepository;

    public List<Medicalfile> getAllMedicalfile() {
        return medicalfileRepository.findAll();
    }

    public void addMedicalfile(Medicalfile patient) {
        medicalfileRepository.save(patient);
    }

    public void getMedicalfile(UUID uuid) {
        medicalfileRepository.findById(uuid);
    }

    public void updateMedicalfile(UUID id, Medicalfile patient) {
        medicalfileRepository.save(patient);
    }

    public void deleteMedicalfile(UUID uuid) {
        medicalfileRepository.deleteById(uuid);
    }
}
