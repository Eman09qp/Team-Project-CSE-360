import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NewItem extends Stage{
    BorderPane pane = new BorderPane();
    Label foodNameL = new Label("Food Name:");
    Label foodTypeL = new Label("Food Type:");
    Label ingredientsL = new Label("Ingredients:");
    Label priceL = new Label("Price:");
    Label linkL = new Label("Paste Image Link:");
    TextField foodF = new TextField();
    TextField foodTypeF = new TextField();
    TextField ingredientsF = new TextField();
    TextField priceF = new TextField();
    TextField linkF = new TextField();
    Button newItem = new Button("Add to Menu");


    public NewItem(){
        this.setTitle("Add Food Item");
        pane.setPadding(new Insets(20,50,50,50));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(foodNameL, foodF, foodTypeL, foodTypeF, ingredientsL, ingredientsF, priceL, priceF, linkL, linkF, newItem);
        pane.setCenter(vbox);

        newItem.setOnAction(new AccountHandler());

        this.setScene(new Scene(pane));
        this.show();
    }

    private class AccountHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            try {
                Double price = Double.parseDouble(priceF.getText());
                Food newFood = new Food(foodF.getText(),foodTypeF.getText(),ingredientsF.getText(),price,linkF.getText());
                Main.menu.addToMenu(newFood);
                close();
                Admin admin = new Admin("**ADMIN MENU**", Main.menu);
                admin.setWidth(500);
                admin.setHeight(700);
            }
            catch (NumberFormatException e){
                priceL.setTextFill(Color.RED);
            }
        }
    }
}
