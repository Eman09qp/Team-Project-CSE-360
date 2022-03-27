package com.CatJam;

public class Customer extends User {

    private boolean frequent = false;

    // Customer constructor
    public Customer(String customerFirstName,
                    String customerLastName,
                    String customerPhoneNumber,
                    String customerEmail,
                    String customerUserName,
                    String customerPassword,
                    String newStreet,
                    String newCity,
                    String newState,
                    int newZipcode)  {

        super(customerFirstName,
                customerLastName,
                customerPhoneNumber,
                customerEmail,
                customerUserName,
                customerPassword,
                newStreet,
                newCity,
                newState,
                newZipcode);

    }

    public String toString() {
        return  "\nusername:\t\t\t" + userName +
                "\nCustomer full name:\t\t\t" + firstName + " " + lastName +
                "\nPhone number:\t\t\t" + phoneNumber +
                "\nEmail:\t\t\t" + email +
                "\nPassword:\t\t\t" + this.getPassword();
    }


}
