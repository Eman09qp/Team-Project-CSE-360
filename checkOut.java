import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class checkOut extends Stage {
    ScrollPane scrollPane = new ScrollPane();
    GridPane pane = new GridPane();
    HBox subTotalBox = new HBox();
    HBox couponBox = new HBox();
    HBox totalBox = new HBox();
    HBox placeOrderBox = new HBox();

    public checkOut(User newUser){
        double total = newUser.getTotal() - newUser.getCoupon().getDiscount();

        pane.setPadding(new Insets(10,20,30,20));
        pane.setAlignment(Pos.CENTER_RIGHT);
        subTotalBox.setSpacing(30);
        subTotalBox.setPadding(new Insets(20,0,0,0));
        subTotalBox.setAlignment(Pos.TOP_RIGHT);
        couponBox.setSpacing(30);
        couponBox.setPadding(new Insets(20,0,0,0));
        couponBox.setAlignment(Pos.TOP_RIGHT);
        totalBox.setSpacing(30);
        totalBox.setPadding(new Insets(20,0,0,0));
        totalBox.setAlignment(Pos.TOP_RIGHT);
        placeOrderBox.setAlignment(Pos.TOP_RIGHT);
        placeOrderBox.setSpacing(30);
        placeOrderBox.setPadding(new Insets(20,0,0,0));
        placeOrderBox.setAlignment(Pos.TOP_RIGHT);

        // Add all items in user cart
        int n = 0;
        while(n < newUser.getMyCart().size()){
            HBox myItemBox = newItem(newUser.getMyCart().get(n));
            pane.add(myItemBox, 0,n);
            n++;
        }

        Label subTotal = new Label("SubTotal:   $" + String.format("%.2f",newUser.getSubTotal()));
        subTotalBox.getChildren().add(subTotal);

        Label coupon = new Label("Coupon: ");
        TextField couponField = new TextField();
        Button apply = new Button("Apply");
        couponBox.getChildren().addAll(coupon, couponField, apply);

        Label tot = new Label("Total:   $" + String.format("%.2f",newUser.getSubTotal()));
        totalBox.getChildren().add(tot);

        Button placeOrder = new Button("Place Order");
        placeOrderBox.getChildren().add(placeOrder);

        pane.add(subTotalBox, 0, n);
        n++;
        pane.add(couponBox, 0, n);
        n++;
        pane.add(totalBox, 0, n);
        n++;
        pane.add(placeOrderBox, 0, n);

        scrollPane.setContent(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        this.setTitle("Check Out");
        this.setScene(new Scene(scrollPane));
        this.show();
    }


    public HBox newItem(Food item){
        HBox itemBox = new HBox();
        itemBox.setSpacing(30);
        itemBox.setPadding(new Insets(20,0,0,0));
        itemBox.setAlignment(Pos.TOP_RIGHT);

        Label foodName = new Label(item.getName());
        Label ingredients = new Label("Ingredients:     " + item.getIngredients());
        Label foodPrice = new Label("Price:     $" + String.format("%.2f",item.getPrice()));
        Button remove = new Button("Remove");
        itemBox.getChildren().addAll(foodName, ingredients, foodPrice, remove);
        return itemBox;
    }

}
