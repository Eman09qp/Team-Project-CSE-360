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
    
    //Returns the total price of all items in cart
    public double getTotal(){
        double total = 0.0;
        for(int n = 0; n < cart.size(); n++)
        {
            total += cart.get(n).getPrice();
        }
        return total;
    }

    //Returns a string of all the names of the items in the cart
    public String getCart(){
        String shoppingList = "";
        for(int n = 0; n < cart.size(); n++){
            if(n == cart.size()-1)
                shoppingList += cart.get(n).getName();
            else
                shoppingList += cart.get(n).getName() + ", ";

        }
        return shoppingList;
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
