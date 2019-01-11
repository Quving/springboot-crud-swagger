package asclepius;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class MongoDocument {

    @Id
    @ApiModelProperty(readOnly = true)
    protected UUID uuid;

    public MongoDocument() {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
