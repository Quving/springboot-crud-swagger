package asclepius.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    private NurseService _nurseService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addNurse(@RequestBody Nurse nurse) {
        _nurseService.addNurse(nurse);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public Optional<Nurse> getNurse(@PathVariable String id) {
        return _nurseService.getNurse(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteNurse(@PathVariable String id) {
        _nurseService.deleteNurse(UUID.fromString(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateNurse(@RequestBody Nurse person, @PathVariable String id) {
        _nurseService.updateNurse(UUID.fromString(id), person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Nurse> getAllNurse() {
        return _nurseService.getAllNurse();
    }
}
