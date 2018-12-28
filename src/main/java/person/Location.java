package person;

import org.json.JSONObject;

public class Location {
    private String _street;
    private String _city;
    private String _country;
    private String _postalzip;
    private String _other;

    public Location(String street, String city, String postalzip, String country, String other) {
        _street = street;
        _city = city;
        _country = country;
        _postalzip = postalzip;
        _other = other;
    }

    public Location() {
        _street = "";
        _city = "";
        _country = "";
        _postalzip = "";
        _other = "";

    }


    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }


    public String getStreet() {
        return _street;
    }

    public void setStreet(String _street) {
        this._street = _street;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String _city) {
        this._city = _city;
    }

    public String getPostalzip() {
        return _postalzip;
    }

    public void setPostalzip(String _postalzip) {
        this._postalzip = _postalzip;
    }

    public String getOther() {
        return _other;
    }

    public void setOther(String _other) {
        this._other = _other;
    }

    public String toJson() {
        JSONObject jo = new JSONObject();
        jo.put("street", _street);
        jo.put("city", _city);
        jo.put("country", _country);
        jo.put("postalzip", _postalzip);
        jo.put("other", _other);
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
        boolean equals = _city.equals(location._city) &&
                _country.equals(location._country) &&
                _postalzip.equals(location._postalzip) &&
                _other.equals(location._other) &&
                _street.equals(location._street);
        return equals;
    }
}
