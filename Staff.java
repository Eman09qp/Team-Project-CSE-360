
public class Staff extends User {

    // Staff constructor
    public Staff(String staffFirstName,
                 String staffLastName,
                 String staffPhoneNumber,
                 String staffEmail,
                 String staffUsername,
                 String staffPassword,
                 //int staffApartmentNumber,
                 String newStreet,
                 String newCity,
                 String newState,
                 int newZipcode, String payName, String payNum, String payDate, int payCode)
    {
        super(staffFirstName,
                staffLastName,
                staffPhoneNumber,
                staffEmail,
                staffUsername,
                staffPassword,
                //staffApartmentNumber,
                newStreet,
                newCity,
                newState,
                newZipcode, payName, payNum, payDate, payCode);
    }

    //Sets the frequent boolean as true in the Customer class
    public void giveCoupon(Customer frequentCustomer){
        frequentCustomer.setFrequent();
    }
}
