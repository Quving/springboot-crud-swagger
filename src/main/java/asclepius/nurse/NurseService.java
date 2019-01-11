package asclepius.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NurseService {

    @Autowired
    NurseRepository nurseRepository;

    public List<Nurse> getAllNurse() {
        return nurseRepository.findAll();
    }

    public void addNurse(Nurse patient) {
        nurseRepository.save(patient);
    }

    public void getNurse(UUID uuid) {
        nurseRepository.findById(uuid);
    }

    public void updateNurse(UUID id, Nurse patient) {
        nurseRepository.save(patient);
    }

    public void deleteNurse(UUID uuid) {
        nurseRepository.deleteById(uuid);
    }
}
