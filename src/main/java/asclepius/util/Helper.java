package asclepius.util;

import java.util.UUID;

public class Helper {
    public static boolean isUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
