package asclepius.medicalfile;

import asclepius.nurse.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicalfileService {

    @Autowired
    MedicalfileRepository medicalfileRepository;
    @Autowired
    NurseRepository nurseRepository;

    public List<Medicalfile> getAllMedicalfile() {
        return medicalfileRepository.findAll();
    }

    public void addMedicalfile(Medicalfile patient) {
        medicalfileRepository.save(patient);
    }

    public Optional<Medicalfile> getMedicalfile(UUID uuid) {
        return medicalfileRepository.findById(uuid);
    }

    public void updateMedicalfile(UUID id, Medicalfile medicalfile) {
        medicalfileRepository.save(medicalfile);
    }

    public void deleteMedicalfile(UUID uuid) {
        medicalfileRepository.deleteById(uuid);
    }

    public void addNurseToMedicalfile(UUID medicalfile_id, UUID nurse_id) {
        if (nurseRepository.existsById(nurse_id)) {
            Medicalfile medicalfile = getMedicalfile(medicalfile_id).get();
            medicalfile.addNurse(nurse_id);
            updateMedicalfile(medicalfile_id, medicalfile);
        }
    }

    public void removeNurseFromMedicalfile(UUID medicalfile_id, UUID nurse_id) {
        if (nurseRepository.existsById(nurse_id)) {
            Medicalfile medicalfile = getMedicalfile(medicalfile_id).get();
            medicalfile.removeNurse(nurse_id);
            updateMedicalfile(medicalfile_id, medicalfile);
        }
    }
}
