package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public void getPerson(@PathVariable String uuid) {
        personService.getPerson(uuid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deletePerson(UUID uuid) {
        personService.deletePerson(uuid);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable String id) {
        personService.updatePerson(id, person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }
}
