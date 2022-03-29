import java.util.LinkedList;

public class Customer extends User {

    private boolean frequent = false;
    LinkedList<Food> cart = new LinkedList<Food>();

    // Customer constructor
    public Customer(String customerFirstName,
                    String customerLastName,
                    String customerPhoneNumber,
                    String customerEmail,
                    String customerUserName,
                    String customerPassword,
                    int customerApartmentNumber,
                    String customerStreet,
                    String newCity,
                    String newState,
                    int newZipcode)  {

        super(customerFirstName,
                customerLastName,
                customerPhoneNumber,
                customerEmail,
                customerUserName,
                customerPassword,
                customerApartmentNumber,
                customerStreet,
                newCity,
                newState,
                newZipcode);

    }

    public void printCart(){
        for(int n = 0; n < cart.size(); n++){
            if(n == cart.size()-1)
                System.out.print(cart.get(n).getName());
            else
                System.out.print(cart.get(n).getName() + ", ");
        }
    }

    public boolean isFrequentCustomer() {
        return frequent;
    }

    public void setFrequent() {
        this.frequent = true;
    }
}
