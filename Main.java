import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    static ArrayList<User> userList = new ArrayList<>();
    static Menu menu = new Menu();

    public void start(Stage primaryStage) {

        Menu restaurantMenu = new Menu("Wàn mín Takeout");
        createAccount promptCreateAccount = new createAccount();
    }

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

        //System.out.println("FOOD: " + menu.getMenu().get("Goulash").getName());

        System.out.println("\nMENU:");
        for (Food i : menu.getMenu().values()) {
            System.out.println(i.toString());
        }

        launch(args);



        // SAVE USERS INTO Users.dat
        saveUsers(userFile);

        // SAVE MENU INTO Menu.dat
        saveMenu(menuFile);
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
                        state = state.trim();
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
