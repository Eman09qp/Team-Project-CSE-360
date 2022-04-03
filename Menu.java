import java.util.HashMap;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Menu extends Stage {
    private HashMap<String, Food> menu;
    
    // pane holds the toolBar and the food items
    GridPane pane = new GridPane();
    HBox toolBar = new HBox();
    HBox item1 = new HBox();
    HBox item2 = new HBox();

    // Create all necessary nodes
    Label restaurantName = new Label("Restaurant App");
    Label search = new Label ("search");
    TextField searchBar = new TextField();
    Button createAccount = new Button("Create Account");
    Button login = new Button("Login");

    Label foodImage = new Label("[image of food]");
    Label foodItem = new Label ("Food Item");
    TextField foodItemQuantity = new TextField();
    Button add = new Button("Add");
    Button delete = new Button("Delete");

    Label foodImage1 = new Label("[image of food]");
    Label foodItem1 = new Label ("Food Item");
    TextField foodItemQuantity1 = new TextField();
    Button add1 = new Button("Add");
    Button delete1 = new Button("Delete");

    public Menu() {
        menu  = new HashMap<String, Food>();
    }

    public void addToMenu (Food newFood) {
        menu.put(newFood.getName(), newFood);
    }

    public void removeFromMenu(String rm) {
        try {
            menu.remove(rm);

        } catch (UnknownError e){
            System.out.println("Could not remove");
        }
    }

    public Food searchMenu(String search) {
        return menu.get(search);
    }
    
    Menu(String newRestaurantName){
            //Set up properties of each pane
            toolBar.setAlignment(Pos.CENTER);
            toolBar.setPadding(new Insets(10,10,10,10));
            toolBar.setSpacing(10);

            item1.setAlignment(Pos.TOP_CENTER); //the GridPane will be in center of the scene
            item1.setPadding(new Insets(10, 10, 10, 10));
            item1.setSpacing(10);

            item2.setAlignment(Pos.TOP_CENTER); //the GridPane will be in center of the scene
            item2.setPadding(new Insets(10, 10, 10, 10));
            item2.setSpacing(10);

            toolBar.getChildren().addAll(restaurantName, search, searchBar, createAccount, login);

            item1.getChildren().addAll(foodImage, foodItem, foodItemQuantity, add, delete);
            item2.getChildren().addAll(foodImage1, foodItem1, foodItemQuantity1, add1, delete1);

            // Setup the layout of pane, toolBar and Menu
            pane.add(toolBar, 0 , 0);
            pane.add(item1, 0, 1);
            pane.add(item2, 0, 2);

            this.setTitle(newRestaurantName);
            this.setScene(new Scene(pane)); // Place the scene in the stage
            this.show(); // Display the stage*/
        }
}

