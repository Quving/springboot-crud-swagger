package person;

import java.util.UUID;

public class Person {
    private String _name;
    private UUID _uuid;
    private Location _location;


    public Person(String name) {
        _name = name;
        _uuid = UUID.randomUUID();
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
}
