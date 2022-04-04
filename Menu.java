import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.HashMap;

public class Menu extends Stage {
    private HashMap<String, Food> menu;

    // pane holds the toolBar and the food items
    GridPane pane = new GridPane();
    HBox toolBar = new HBox();
    HBox Goulash= new HBox();
    HBox descr = new HBox();
    HBox goldenCrab = new HBox();
    HBox tripleLayeredConsomme = new HBox();
    HBox moonPie = new HBox();
    HBox tianshuMeat = new HBox();
    HBox holdCheckButton = new HBox();

    // Create all necessary nodes
    Label restaurantName = new Label("万民 - Wàn mín Takeout");
    Label search = new Label ("search");
    TextField searchBar = new TextField();
    Button createAccount = new Button("Create Account");
    Button login = new Button("Login");
    Button checkOut = new Button("Check out");

    //Overloaded Constructor
    public Menu(String newRestaurantName){
        holdCheckButton.setAlignment(Pos.BASELINE_RIGHT);
        holdCheckButton.getChildren().add(checkOut);
        holdCheckButton.setPadding(new Insets(25,50,25,0));
        //Set up properties of each pane
        toolBar.setAlignment(Pos.TOP_CENTER);
        toolBar.setPadding(new Insets(10,50,10,10));
        toolBar.setSpacing(10);

        Goulash.setAlignment(Pos.CENTER_RIGHT); //the GridPane will be in center of the scene
        Goulash.setPadding(new Insets(10, 50, 10, 10));
        Goulash.setSpacing(10);
        TextField enterNum = new TextField();
        enterNum.setMaxWidth(30);

        goldenCrab.setAlignment(Pos.CENTER_RIGHT); //the GridPane will be in center of the scene
        goldenCrab.setPadding(new Insets(10, 50, 10, 10));
        goldenCrab.setSpacing(10);
        TextField enterNum1 = new TextField();
        enterNum1.setMaxWidth(30);

        tripleLayeredConsomme.setAlignment(Pos.CENTER_RIGHT); //the GridPane will be in center of the scene
        tripleLayeredConsomme.setPadding(new Insets(10, 50, 10, 10));
        tripleLayeredConsomme.setSpacing(10);
        TextField enterNum2 = new TextField();
        enterNum2.setMaxWidth(30);

        moonPie.setAlignment(Pos.CENTER_RIGHT); //the GridPane will be in center of the scene
        moonPie.setPadding(new Insets(10, 50, 10, 10));
        moonPie.setSpacing(10);
        TextField enterNum3 = new TextField();
        enterNum3.setMaxWidth(30);

        tianshuMeat.setAlignment(Pos.CENTER_RIGHT); //the GridPane will be in center of the scene
        tianshuMeat.setPadding(new Insets(10, 50, 10, 10));
        tianshuMeat.setSpacing(10);
        TextField enterNum4 = new TextField();
        enterNum4.setMaxWidth(30);

        toolBar.getChildren().addAll(restaurantName, search, searchBar, createAccount, login);


        Goulash.getChildren().addAll(new Label("[Food Image]"),
                new Label("Goulash"),
                enterNum,
                new Button("Add"),
                new Button("Delete"));
        Label ingredients = new Label("Ingredients: Chilled meat, Carrot, Tomato    Price: $4.59");

        goldenCrab.getChildren().addAll(new Label("[Food Image]"),
                new Label("Golden Crab"),
                enterNum1,
                new Button("Add"),
                new Button("Delete"));
        Label ingr1 = new Label("Ingredients: Bird Egg, Flour, Crab, Salt   Price: $20.90");

        tripleLayeredConsomme.getChildren().addAll(new Label("[Food Image]"),
                new Label("Triple-Layered Consomme"),
                enterNum2,
                new Button("Add"),
                new Button("Delete"));
        Label ingr2 = new Label("Ingredients: Ham, Fowl, Bamboo shoot, Mushroom     Price: $12.90");

        moonPie.getChildren().addAll(new Label("[Food Image]"),
                new Label(" Moon Pie"),
                enterNum3,
                new Button("Add"),
                new Button("Delete"));
        Label ingr3 = new Label("Ingredients: Raw meat, Bird egg, butter, small lamp grass      Price: $5.99");

        tianshuMeat.getChildren().addAll(new Label("[Food Image]"),
                new Label("Tianshu Meat"),
                enterNum4,
                new Button("Add"),
                new Button("Delete"));
        Label ingr4 = new Label("Ingredients: Raw meat, Sugar, Qingxin, Matsutake       Price: $7.80");

        ingredients.setPadding(new Insets(0, 50, 20, 50));
        ingr1.setPadding(new Insets(0, 50, 20, 50));
        ingr2.setPadding(new Insets(0, 50, 20, 50));
        ingr3.setPadding(new Insets(0, 50, 20, 50));
        ingr4.setPadding(new Insets(0, 50, 20, 50));

        // Setup the layout of pane, toolBar and Menu
        pane.add(toolBar, 0 , 0);
        pane.add(Goulash, 0, 1);
        pane.add(ingredients, 0, 2);
        pane.add(goldenCrab, 0, 3);
        pane.add(ingr1, 0, 4);
        pane.add(tripleLayeredConsomme, 0, 5);
        pane.add(ingr2, 0, 6);
        pane.add(moonPie, 0, 7);
        pane.add(ingr3, 0, 8);
        pane.add(tianshuMeat, 0 , 9);
        pane.add(ingr4, 0 ,10);
        pane.add(holdCheckButton,0,11);

        this.setTitle(newRestaurantName);
        this.setScene(new Scene(pane)); // Place the scene in the stage

        this.show(); // Display the stage*/
    }


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

    public HashMap<String, Food> getMenu() {
        return menu;
    }
}

