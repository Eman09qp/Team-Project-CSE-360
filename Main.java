
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;

import java.util.LinkedList;
import java.util.ArrayList;

public class Main extends Application {
    static ArrayList<User> userList = new ArrayList<>();
    static Menu menu = new Menu();
    public static void main(String[] args) {
        String userFile = "Users.dat";
        String menuFile = "Menu.dat";

        //READ Users.dat

        readUsers(userFile);

        System.out.println("USERS:");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }

        //READ Menu.dat
        readMenu(menuFile);

        System.out.println("\nMENU:");
        for (Food i : menu.getMenu().values()) {
            System.out.println(i.toString());
        }

        // TESTING STUFF
        /*
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
                "American",
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
        */
        launch(args);

        // SAVE USERS INTO Users.dat
        saveUsers(userFile);

        // SAVE MENU INTO Menu.dat
        saveMenu(menuFile);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void readUsers(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader (fr);
            String userType = "";
            String username = "";
            String firstName = "";
            String lastName = "";
            String phone = "";
            String street = "";
            String city = "";
            String state = "";
            int zip = 0;
            String email = "";
            String password = "";
            int i = 0;

            String line = bf.readLine();

            while (line != null)
            {
                switch(i) {
                    case 0:
                        String[] split = line.split(" ");
                        userType = split[0];
                        username = split[1];
                        break;
                    case 1:
                        split = line.split(" ");
                        firstName = split[0];
                        lastName = split[1];
                        break;
                    case 2:
                        phone = line;
                        break;
                    case 3:
                        split = line.split(", ");
                        street = split[0];
                        city = split[1];

                        String[] stateSplit = split[2].split(" ");
                        zip = Integer.parseInt(stateSplit[stateSplit.length - 1]);
                        int stringSize = stateSplit.length - 1;
                        for (int j = 0; j < stringSize; j++) {
                            state = state + " " + stateSplit[j];
                        }
                        state = state.strip();
                        break;
                    case 4:
                        email = line;
                        break;
                    case 5:
                        password = line;
                        break;
                }
                i++;
                if (line.compareTo("---") == 0) {
                    if (userType.compareTo("Staff") == 0) {
                        Staff staff = new Staff(firstName, lastName, phone, email, username, password, street, city, state, zip);
                        userList.add(staff);
                    }

                    else if (userType.compareTo("Customer") == 0) {
                        Customer customer = new Customer(firstName, lastName, phone, email, username, password, street, city, state, zip);
                        userList.add(customer);
                    }
                    i = 0;
                    userType = "";
                    username = "";
                    firstName = "";
                    lastName = "";
                    phone = "";
                    street = "";
                    city = "";
                    state = "";
                    zip = 0;
                    email = "";
                    password = "";
                }
                line = bf.readLine();
            }
            bf.close();

        } catch (FileNotFoundException e) { // catch ClassNotFoundException
            System.out.print("File not found exception\n");
        } catch (IOException e) { // catch IOException
            System.out.print("Data file read exception\n");
        }
    }

    public static void saveUsers(String filename) {
        try {
            FileWriter fw = new FileWriter (filename);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw);

            for (int i = 0; i < userList.size(); i++) {
                pw.println(userList.get(i).getClass().toString().replace("class ", "")+ " " + userList.get(i).getUserName());
                pw.println(userList.get(i).getFullName());
                pw.println(userList.get(i).getPhoneNumber());
                pw.println(userList.get(i).getUserAddress().getAddress());
                pw.println(userList.get(i).getEmail());
                pw.println(userList.get(i).getPassword());
                pw.println("---");
            }

            pw.close(); // closing file
        } catch (IOException e) { // catching IOException
            System.out.print("Data file written exception\n");
        }
    }

    public static void readMenu(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader (fr);
            String foodName = "";
            String foodType = "";
            String ingredients = "";
            double price = 0.0;
            int i = 0;

            String line = bf.readLine();

            while (line != null)
            {
                switch(i) {
                    case 0:
                        foodName = line;
                        break;
                    case 1:
                        foodType = line;
                        break;
                    case 2:
                        ingredients = line;
                        break;
                    case 3:
                        price = Double.parseDouble(line);
                        break;
                }
                i++;
                if (line.compareTo("---") == 0) {
                    Food food = new Food(foodName, foodType, ingredients, price);
                    menu.addToMenu(food);

                    i = 0;
                    foodName = "";
                    foodType = "";
                    ingredients = "";
                    price = 0.0;
                }
                line = bf.readLine();
            }
            bf.close();

        } catch (FileNotFoundException e) { // catch ClassNotFoundException
            System.out.print("File not found exception\n");
        } catch (IOException e) { // catch IOException
            System.out.print("Data file read exception\n");
        }
    }

    public static void saveMenu(String filename) {
        try {
            FileWriter fw = new FileWriter (filename);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw);

            for (Food i : menu.getMenu().values()) {
                pw.println(i.getName());
                pw.println(i.getFoodType());
                pw.println(i.getIngredients());
                pw.println(i.getPrice());
                pw.println("---");
            }

            pw.close(); // closing file
        } catch (IOException e) { // catching IOException
            System.out.print("Data file written exception\n");
        }
    }
}
