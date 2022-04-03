
public class Address {
    private String street = "";
    private String city = "";
    private String state = "";
    private int zipCode = 0;

    public Address(String newStreet, String newCity, String newState, int newZip){
        //apartmentNumber = newApartmentNumber;
        street = newStreet;
        city = newCity;
        state = newState;
        zipCode = newZip;
    }

    public String getAddress() { return street + ", " + city + ", " + state + " " + zipCode; }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    //public int getApartmentNumber() { return apartmentNumber; }

    //public void setApartmentNumber(int apartmentNumber) { this.apartmentNumber = apartmentNumber; }
}
