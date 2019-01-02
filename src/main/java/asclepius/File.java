package asclepius;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class File {
    @Id
    protected String _uuid;
    protected Date _created_at;

    public File() {
        _uuid = UUID.randomUUID().toString();
        _created_at = new Date();
    }

    public String get_uuid() {
        return _uuid;
    }

    public void set_uuid(String uuid) {
        _uuid = uuid;
    }

    public Date get_created_at() {
        return _created_at;
    }

    public void set_created_at(Date created_at) {
        _created_at = created_at;
    }
}
