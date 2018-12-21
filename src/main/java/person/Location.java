package person;

public class Location {
    private String _street;
    private String _city;
    private String _postalzip;
    private String _other;

    public Location(String street, String city, String postalzip, String other) {
        _street = street;
        _city = city;
        _postalzip = postalzip;
        _other = other;
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
}
