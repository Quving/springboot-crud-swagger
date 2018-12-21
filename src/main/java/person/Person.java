package person;

import java.util.UUID;

public class Person {
    private String _name;
    private UUID _uuid;


    public Person(String name) {
        _name = name;
        _uuid = UUID.randomUUID();
    }

    /**
     * Returns the UUID.
     *
     * @return
     */
    public UUID getUUID() {
        return _uuid;
    }

    /**
     * Returns the name.
     *
     * @return
     */
    public String getName() {
        return _name;
    }
}
