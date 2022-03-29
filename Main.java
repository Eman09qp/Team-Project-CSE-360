
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Staff Abigail = new Staff("Abigail",
                "Williams",
                "480 123 4567",
                "abigail123@hotmail.com",
                "abyWill",
                "securePassword123",
                1234,
                "Rural road",
                "Tempe",
                "Arizona",
                879100);

        Customer Carlos = new Customer("Carlos",
                "Perez",
                "480 891 2323",
                "carlosPerez@hotmail.com",
                "carlitosP",
                "iDontKnow456",
                3456,
                "Eastern Ave",
                "Phoenix",
                "Arizona",
                879100);

        System.out.println(Abigail.toString());
        System.out.println(Carlos.toString());
        Food Pizza = new Food("Dominoes Pizza",
                "American?",
                "Flour, tomato sauce, pepperoni, mozzarella cheese",
                5.99);
        Food Hamburger = new Food("Hamburger",
                "American",
                "Bread, quarter pound beef, bacon, lettuce, tomato, cheese",
                4.59);

        Carlos.cart.add(Pizza);
        Carlos.cart.add(Hamburger);
        System.out.print("Cart: ");
        Carlos.printCart();
    }
}

