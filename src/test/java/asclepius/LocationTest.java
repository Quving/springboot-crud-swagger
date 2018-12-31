package asclepius;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void toJson() {
        Location location = new Location("Laemmersieth", "Hamburg", "20097", "Germany", "app. 6.09");
        String expected = "{\"country\":\"Germany\",\"other\":\"app. 6.09\",\"city\":\"Hamburg\",\"street\":\"Laemmersieth\",\"postalzip\":\"20097\"}";
        assertEquals(location.toJson(), expected);
    }

    @Test
    public void fromJson() {
        Location location = new Location("Laemmersieth", "Hamburg", "20097", "Germany", "app. 6.09");
        String json = "{\"country\":\"Germany\",\"other\":\"app. 6.09\",\"city\":\"Hamburg\",\"street\":\"Laemmersieth\",\"postalzip\":\"20097\"}";
        Location location1 = Location.fromJson(json);
        assertTrue(location.equals(location1));
    }
}