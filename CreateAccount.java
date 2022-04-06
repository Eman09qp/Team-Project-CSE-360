import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateAccount extends Stage{
    GridPane pane = new GridPane();


    HBox userNameBoxTitle = new HBox();
    HBox userNameBoxField = new HBox();
    HBox emailBoxTitle = new HBox();
    HBox emailBoxField = new HBox();
    HBox addressBoxTitle = new HBox();
    HBox addressBoxField = new HBox();
    HBox nameOnCardTitle = new HBox();
    HBox nameOnCardField = new HBox();
    HBox secCodeTitle = new HBox();
    HBox secCodeField = new HBox();
    TextField username = new TextField();
    TextField firstname = new TextField();
    TextField lastname = new TextField();
    TextField addressText = new TextField();
    TextField cityText = new TextField();
    TextField stateText = new TextField();
    TextField zipcodeText = new TextField();
    TextField passwordText = new TextField();
    TextField cardName = new TextField();
    TextField cardNumber = new TextField();
    TextField expiration = new TextField();
    TextField securityCode = new TextField();
    TextField emailText = new TextField();
    TextField numberText = new TextField();


    HBox passwordBoxTitle = new HBox();
    HBox passwordBoxField = new HBox();

    public CreateAccount(){
        pane.setPadding(new Insets(20,50,50,50));

        Label userName = new Label("User Name");
        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");

        userNameBoxTitle.setAlignment(Pos.CENTER_LEFT);
        userNameBoxTitle.setPadding(new Insets(0, 50, 0, 50));
        userNameBoxTitle.setSpacing(100);
        userNameBoxTitle.getChildren().addAll(userName, firstName,lastName);
        userNameBoxField.setAlignment(Pos.TOP_CENTER);
        userNameBoxField.setPadding(new Insets(10, 50, 10, 50));
        userNameBoxField.setSpacing(10);
        userNameBoxField.getChildren().addAll(username, firstname, lastname);

        Label email = new Label("Email");
        Label mobile = new Label("Mobile Number");

        emailBoxTitle.setAlignment(Pos.CENTER_LEFT);
        emailBoxTitle.setPadding(new Insets(0, 50, 0, 50));
        emailBoxTitle.setSpacing(130);
        emailBoxTitle.getChildren().addAll(email,mobile);
        emailBoxField.setAlignment(Pos.CENTER_LEFT);
        emailBoxField.setPadding(new Insets(10, 50, 10, 50));
        emailBoxField.setSpacing(10);
        emailBoxField.getChildren().addAll(emailText, numberText);


        Label address = new Label("Address");
        Label city = new Label("City");
        Label state = new Label("State");
        Label zipcode = new Label("ZIP Code");
        address.setPadding(new Insets(10,0,0,0));

        addressBoxTitle.setAlignment(Pos.CENTER_LEFT);
        addressBoxTitle.setPadding(new Insets(0, 50, 0, 50));
        addressBoxTitle.setSpacing(100);
        addressBoxTitle.getChildren().addAll(address, city, state, zipcode);
        addressBoxField.setAlignment(Pos.CENTER_LEFT);
        addressBoxField.setPadding(new Insets(10, 50, 10, 50));
        addressBoxField.setSpacing(10);
        addressBoxField.getChildren().addAll(addressText, cityText, stateText, zipcodeText);

        Label password = new Label("Password");
        password.setPadding(new Insets(10,0,0,0));

        passwordBoxTitle.setAlignment(Pos.CENTER_LEFT);
        passwordBoxTitle.setPadding(new Insets(0, 50, 0, 50));
        passwordBoxTitle.setSpacing(100);
        passwordBoxTitle.getChildren().addAll(password);
        passwordBoxField.setAlignment(Pos.CENTER_LEFT);
        passwordBoxField.setPadding(new Insets(10, 50, 10, 50));
        passwordBoxField.setSpacing(10);
        passwordBoxField.getChildren().addAll(passwordText);

        Label nameOnCard = new Label("Name on card");
        Label cardNum = new Label("Card Number");
        Label expDate = new Label("Expiration Date");

        nameOnCardTitle.setAlignment(Pos.CENTER_LEFT);
        nameOnCardTitle.setPadding(new Insets(0, 50, 0, 50));
        nameOnCardTitle.setSpacing(90);
        nameOnCardTitle.getChildren().addAll(nameOnCard, cardNum, expDate);
        nameOnCardField.setAlignment(Pos.CENTER_LEFT);
        nameOnCardField.setPadding(new Insets(10, 50, 10, 50));
        nameOnCardField.setSpacing(10);
        nameOnCardField.getChildren().addAll(cardName, cardNumber, expiration);

        Label secCode = new Label("Security Code");
        secCodeTitle.setAlignment(Pos.CENTER_LEFT);
        secCodeTitle.setPadding(new Insets(0, 50, 0, 50));
        secCodeTitle.setSpacing(100);
        secCodeTitle.getChildren().addAll(secCode);
        secCodeField.setAlignment(Pos.CENTER_LEFT);
        secCodeField.setPadding(new Insets(10, 50, 10, 50));
        secCodeField.setSpacing(10);
        secCodeField.getChildren().addAll(securityCode);

        HBox createAccBox = new HBox();
        createAccBox.setAlignment(Pos.CENTER_RIGHT);
        createAccBox.setPadding(new Insets(0,50,0,0));

        Button createAcc = new Button("Create Account");
        createAcc.setAlignment(Pos.CENTER_RIGHT);
        //createAcc.setPadding(new Insets(10,50,50,50));
        createAccBox.getChildren().add(createAcc);


        pane.add(userNameBoxTitle,0,0);
        pane.add(userNameBoxField, 0,1);
        pane.add(emailBoxTitle,0,2);
        pane.add(emailBoxField,0,3);
        pane.add(addressBoxTitle,0,4);
        pane.add(addressBoxField,0,5);
        pane.add(nameOnCardTitle,0,6);
        pane.add(nameOnCardField,0,7);
        pane.add(secCodeTitle, 0, 8);
        pane.add(secCodeField, 0,9);
        pane.add(passwordBoxTitle,0,10);
        pane.add(passwordBoxField,0,11);
        pane.add(createAccBox, 0,12);

        createAcc.setOnAction(new AccountHandler());

        this.setTitle("Create Account");
        this.setScene(new Scene(pane));
        this.show();
    }

    private class AccountHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Customer customer = new Customer(firstname.getText(),
                    lastname.getText(),
                    numberText.getText(),
                    emailText.getText(),
                    username.getText(),
                    passwordText.getText(),
                    addressText.getText(),
                    cityText.getText(),
                    stateText.getText(),
                    Integer.parseInt(zipcodeText.getText()),
                    cardName.getText(),
                    cardNumber.getText(),
                    expiration.getText(),
                    Integer.parseInt(securityCode.getText()));
            Main.menu.setCustomer(customer);
            Main.userList.add(customer);
            Platform.exit();
        }
    }
}
