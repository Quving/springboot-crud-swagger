package asclepius;

import org.json.JSONObject;

public class Location {
    private String street;
    private String city;
    private String country;
    private String postalzip;
    private String other;

    public Location(String street, String city, String postalzip, String country, String other) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalzip = postalzip;
        this.other = other;
    }

    public Location() {
        street = "";
        city = "";
        country = "";
        postalzip = "";
        other = "";
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String _street) {
        this.street = _street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String _city) {
        this.city = _city;
    }

    public String getPostalzip() {
        return postalzip;
    }

    public void setPostalzip(String _postalzip) {
        this.postalzip = _postalzip;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String _other) {
        this.other = _other;
    }

    public String toJson() {
        JSONObject jo = new JSONObject();
        jo.put("street", street);
        jo.put("city", city);
        jo.put("country", country);
        jo.put("postalzip", postalzip);
        jo.put("other", other);
        return jo.toString();
    }

    public static Location fromJson(String json) {
        JSONObject jo = new JSONObject(json);
        String street = jo.getString("street");
        String country = jo.getString("country");
        String postalzip = jo.getString("postalzip");
        String other = jo.getString("other");
        String city = jo.getString("city");
        Location location = new Location(street, city, postalzip, country, other);

        return location;
    }

    public boolean equals(Location location) {
        boolean equals = city.equals(location.city) &&
                country.equals(location.country) &&
                postalzip.equals(location.postalzip) &&
                other.equals(location.other) &&
                street.equals(location.street);
        return equals;
    }
}
