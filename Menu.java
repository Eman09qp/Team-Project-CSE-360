import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Menu extends Stage {
    private ArrayList<Food> menu;

    // pane holds the toolBar and the food items
    GridPane pane = new GridPane();
    ScrollPane scrollPane = new ScrollPane();

    ArrayList<VBox> display = new ArrayList<VBox>();


    HBox toolBar = new HBox();
    HBox holdCheckButton = new HBox();

    // Create all necessary nodes
    Label restaurantName = new Label("万民 - Wàn mín Takeout");
    Label search = new Label ("search");
    TextField searchBar = new TextField();
    Button createAccount = new Button("Create Account");
    Button login = new Button("Login");
    Button checkOut = new Button("Check out");

    //Overloaded Constructor
    public Menu(String newRestaurantName, Menu saved){
        menu  = new ArrayList<Food>();
        for (int i = 0; i < saved.menuSize(); i++) {
            menu.add(saved.getFood(i));
        }

            for (int i = 0; i < menu.size(); i++) {
                System.out.println("Test");
                String name = menu.get(i).getName();
                Food newFood = menu.get(i);
                HBox tempBox = new HBox();
                VBox tempBox2 = new VBox();
                tempBox.setAlignment(Pos.CENTER_RIGHT);
                tempBox.setPadding(new Insets(10, 50, 10, 10));
                tempBox.setSpacing(10);
                TextField enterNum = new TextField();
                enterNum.setMaxWidth(30);

                tempBox.getChildren().addAll(new Label("[Food Image]"),
                        new Label(name),
                        enterNum,
                        new Button("Add"),
                        new Button("Delete"));
                Label ingredients = new Label("Ingredients: " + newFood.getIngredients() + "   Price: $" + String.format("%.2f",newFood.getPrice()));
                tempBox2.getChildren().addAll(tempBox, ingredients);
                ingredients.setPadding(new Insets(0, 50, 20, 50));

                display.add(tempBox2);

            }

        holdCheckButton.setAlignment(Pos.BASELINE_RIGHT);
        holdCheckButton.getChildren().add(checkOut);
        holdCheckButton.setPadding(new Insets(25,50,25,0));
        //Set up properties of each pane
        toolBar.setAlignment(Pos.TOP_CENTER);
        toolBar.setPadding(new Insets(10,50,10,10));
        toolBar.setSpacing(10);

        toolBar.getChildren().addAll(restaurantName, search, searchBar, createAccount, login);

        // Setup the layout of pane, toolBar and Menu
        int i = 0;
        pane.add(toolBar, 0 , 0);
        i++;

        while (i <= menu.size()) {
            pane.add(display.get(i - 1), 0, i);
            i++;
        }
        pane.add(holdCheckButton,0,i);

        scrollPane.setContent(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        this.setTitle(newRestaurantName);
        this.setScene(new Scene(scrollPane)); // Place the scene in the stage

        this.show(); // Display the stage*/
        System.out.println(menuSize());
    }


    public Menu() {
        menu  = new ArrayList<Food>();
    }

    public void addToMenu (Food newFood) {
        menu.add(newFood);
    }

    public int menuSize () {
        return menu.size();
    }

    public Food getFood (int i) {
        return menu.get(i);
    }

   /* public void removeFromMenu(String rm) {
        try {
            menu.remove(rm);

        } catch (UnknownError e){
            System.out.println("Could not remove");
        }
    }

    public Food searchMenu(String search) {
        return menu.get(search);
    }

    public HashMap<String, Food> getMenu() {
        return menu;
    } */
}

