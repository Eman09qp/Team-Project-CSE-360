
import java.util.ArrayList;

public class User {

    coupon newCoupon = new coupon(0);
    protected ArrayList<Food> cart = new ArrayList<Food>();
    protected String firstName = "";
    protected String lastName = "";
    protected String phoneNumber = "";
    protected String email = "";
    protected String userName = "";
    private String password = "";
    Address userAddress;
    Payment payment;

    public User() {}
    // Abstract constructor //
    public User (String newFirstName,
                 String newLastName,
                 String newPhoneNumber,
                 String newEmail,
                 String newUserName,
                 String newPassword,
                 //int newApartmentNumber,
                 String newStreet,
                 String newCity,
                 String newState,
                 int newZipcode, String payName, String payNum, String payDate, int payCode)
    {
        firstName = newFirstName;
        lastName = newLastName;
        phoneNumber = newPhoneNumber;
        email = newEmail;
        userName = newUserName;
        password = newPassword;
        userAddress = new Address(newStreet, newCity, newState, newZipcode);
        payment = new Payment(payName, payNum, payDate, payCode);
    }


    public String toString() {
        return  "\nUserName:\t\t\t" + userName +
                "\nName:\t\t\t" + firstName + " " + lastName +
                "\nPhone number:\t\t\t" + phoneNumber +
                "\nAddress:\t\t\t" + userAddress.getAddress() +
                "\nEmail:\t\t\t" + email +
                "\nPassword:\t\t\t" + this.getPassword() +
                "\nPayment info:\n" + payment.getPayment();
    }

    public double getSubTotal(){
        double subtotal = 0.0;
        for (int n = 0; n < cart.size(); n++)
        {
            subtotal += cart.get(n).getPrice();
        }
        return subtotal;
    }

    public double getTotal(){
        double total = this.getSubTotal();
        if (!(newCoupon.getDiscount() > total)) {
            total = total - this.getCoupon().getDiscount();
        }
        return total;
    }


    public coupon getCoupon(){
        return newCoupon;
    }

    public void setCoupon(double discount){
        newCoupon = new coupon(discount);
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

    public Address getUserAddress() {
        return userAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public ArrayList<Food> getMyCart(){
        return cart;
    }

}



