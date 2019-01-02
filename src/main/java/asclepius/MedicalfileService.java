package asclepius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void getMedicalfile(String uuid) {
        medicalfileRepository.findById(uuid);
    }

    public void updateMedicalfile(String id, Medicalfile patient) {
        medicalfileRepository.save(patient);
    }

    public void deleteMedicalfile(String uuid) {
        medicalfileRepository.deleteById(uuid);
    }
}
