package com.CatJam;

public class Staff extends User {

    // Staff constructor
    public Staff(String staffFirstName,
                 String staffLastName,
                 String staffPhoneNumber,
                 String staffEmail,
                 String staffUsername,
                 String staffPassword,
                 String newStreet,
                 String newCity,
                 String newState,
                 int newZipcode)
    {
        super(staffFirstName,
                staffLastName,
                staffPhoneNumber,
                staffEmail,
                staffUsername,
                staffPassword,
                newStreet,
                newCity,
                newState,
                newZipcode);
    }

    public String toString() {
        return  "\nUserName:\t\t\t" + userName +
                "\nStaff member name:\t\t\t" + firstName + " " + lastName +
                "\nPhone number:\t\t\t" + phoneNumber +
                "\nEmail:\t\t\t" + email +
                "\nPassword:\t\t\t" + this.getPassword();
    }
}
