package asclepius;

import java.util.Date;
import java.util.UUID;

public class File {
    private UUID _uuid;
    private Date _created_at;
    private Date _updated_at;

    public File() {
        _uuid = UUID.randomUUID();
        _created_at = new Date();
    }
}
