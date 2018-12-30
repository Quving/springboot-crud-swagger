package person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "persons")
public class Person {
    @Id
    protected UUID _uuid;
    protected String _name;
    protected String _type;
    protected Location _location;


    public Person(String name) {
        _name = name;
        _uuid = UUID.randomUUID();
        _location = new Location();
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public UUID getUuid() {
        return _uuid;
    }

    public void setUuid(UUID uuid) {
        this._uuid = uuid;
    }

    public Location getLocation() {
        return _location;
    }

    public void setLocation(Location location) {
        this._location = location;
    }

    public boolean equals(Person person) {
        return _name.equals(person._name) &&
                _uuid.equals(person._uuid) &&
                _type.equals(person._type) &&
                _location.equals(person._location);
    }
}
