import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Admin extends Stage {
    private ArrayList<Food> menu;
    private Customer customer = new Customer();

    // pane holds the toolBar and the food items
    GridPane pane = new GridPane();
    ScrollPane scrollPane = new ScrollPane();

    ArrayList<BorderPane> display = new ArrayList<BorderPane>();


    HBox toolBar = new HBox();
    BorderPane holdCheckButton = new BorderPane();

    // Create all necessary nodes
    Label restaurantName = new Label("**ADMIN MENU**");
    Label search = new Label("search");
    TextField searchBar = new TextField();
    Button newItem = new Button("New Item");

    //Overloaded Constructor
    public Admin(String newRestaurantName, Menu saved) {
        menu = new ArrayList<Food>();
        for (int i = 0; i < saved.menuSize(); i++) {
            menu.add(saved.getFood(i));
        }

        for (int i = 0; i < menu.size(); i++) {
            Image image = new Image(menu.get(i).getImage(), 50, 50, true, true);
            ImageView imageView = new ImageView(image);
            String name = menu.get(i).getName();
            Food newFood = menu.get(i);
            HBox tempBox = new HBox();
            HBox tempBox3 = new HBox();
            BorderPane tempBox2 = new BorderPane();
            tempBox.setAlignment(Pos.CENTER_RIGHT);
            tempBox.setPadding(new Insets(10, 50, 10, 10));
            tempBox.setSpacing(10);
            Button delete = new Button("Remove from Menu");

            tempBox3.getChildren().addAll(imageView);

            tempBox.getChildren().addAll(new Label(name), delete);


            Label ingredients = new Label("Ingredients: " + newFood.getIngredients() + "   Price: $" + String.format("%.2f", newFood.getPrice()));

            tempBox2.setLeft(tempBox3);
            tempBox2.setRight(tempBox);
            tempBox2.setBottom(ingredients);

            //tempBox2.getChildren().addAll(tempBox, ingredients);
            ingredients.setPadding(new Insets(0, 50, 20, 50));

            display.add(tempBox2);

            delete.setOnAction(new DeleteHandler());

        }

        toolBar.setAlignment(Pos.TOP_CENTER);
        toolBar.setPadding(new Insets(10, 50, 10, 10));
        toolBar.setSpacing(10);

        toolBar.getChildren().addAll(restaurantName, search, searchBar, newItem);

        // Setup the layout of pane, toolBar and Menu
        int i = 0;
        pane.add(toolBar, 0, 0);
        i++;

        while (i <= menu.size()) {
            pane.add(display.get(i - 1), 0, i);
            i++;
        }
        pane.add(holdCheckButton, 0, i);

        scrollPane.setContent(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        newItem.setOnAction(new NewItemHandler());

        this.setTitle(newRestaurantName);
        this.setScene(new Scene(scrollPane)); // Place the scene in the stage

        this.show(); // Display the stage*/
    }

    private class DeleteHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Button n = (Button) event.getSource();
            HBox temp = (HBox) n.getParent();
            Label food = (Label) temp.getChildren().get(0);
            String string = food.getText();

            removeFromMenu(string);
        }
    }

    private class NewItemHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            new NewItem();
            close();
        }
    }

    public Food getFood(int i) {
        return menu.get(i);
    }

    public void removeFromMenu(String rm) {
        try {
            Main.menu.removeFromMenu(rm);
            Food remove = Main.menu.searchMenu(rm);
            menu.remove(remove);
            this.close();
            Admin admin = new Admin("**ADMIN MENU**", Main.menu);
            admin.setWidth(500);
            admin.setHeight(700);

        } catch (UnknownError e) {
            System.out.println("Could not remove");
        }
    }
}