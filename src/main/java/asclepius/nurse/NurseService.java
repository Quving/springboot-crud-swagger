package asclepius.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void getNurse(String uuid) {
        nurseRepository.findById(uuid);
    }

    public void updateNurse(String id, Nurse patient) {
        nurseRepository.save(patient);
    }

    public void deleteNurse(String uuid) {
        nurseRepository.deleteById(uuid);
    }
}
