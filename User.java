package com.CatJam;

public abstract class User {

    protected String firstName = "";
    protected String lastName = "";
    protected String phoneNumber = "";
    protected String email = "";
    protected String userName = "";
    private String password = "";
    Address userAddress;

    // Abstract constructor //
    public User (String newFirstName,
                 String newLastName,
                 String newPhoneNumber,
                 String newEmail,
                 String newUserName,
                 String newPassword,
                 String newStreet,
                 String newCity,
                 String newState,
                 int newZipcode)
    {
        firstName = newFirstName;
        lastName = newLastName;
        phoneNumber = newPhoneNumber;
        email = newEmail;
        userName = newUserName;
        password = newPassword;
        userAddress = new Address(newStreet, newCity, newState, newZipcode);
    }


    public String toString() {
        return  "\nUserName:\t\t\t" + userName +
                "\nName:\t\t\t" + firstName + " " + lastName +
                "\nPhone number:\t\t\t" + phoneNumber +
                "\nEmail:\t\t\t" + email +
                "\nPassword:\t\t\t" + this.getPassword();
    }

    // Getter and Setter methods
    public String getFullName(){ return firstName + " " + lastName; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) { this.firstName = newFirstName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) { this.lastName = newLastName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
