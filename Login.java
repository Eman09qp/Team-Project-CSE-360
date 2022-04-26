import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Stage{
    GridPane pane = new GridPane();
    Label userLabel = new Label("Username:");
    Label passLabel = new Label("Password:");
    Label fail = new Label("");
    TextField userField = new TextField();
    PasswordField passField = new PasswordField();
    Button loginButton = new Button("Login");

    public Login(){

        pane.setMinSize(400, 200);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        pane.add(userLabel, 0, 0);
        pane.add(userField, 1, 0);
        pane.add(passLabel, 0, 1);
        pane.add(passField, 1, 1);
        pane.add(loginButton, 1, 2);
        pane.add(fail, 1, 3);

        loginButton.setOnAction(new LoginHandler());

        this.setTitle("Login");
        this.setScene(new Scene(pane));
        this.show();
    }

    private class LoginHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            String username = userField.getText();
            String password = passField.getText();
            fail.setTextFill(Color.RED);

            for (int i = 0; i < Main.userList.size(); i++) {
                if (username.compareTo(Main.userList.get(i).getUserName()) == 0) {
                    if (password.compareTo(Main.userList.get(i).getPassword()) == 0) {
                        String userType = Main.userList.get(i).getClass().toString().replace("class ", "");
                        if (userType.compareTo("Customer") == 0) {
                            Main.menu.setCustomer((Customer) Main.userList.get(i));
                            hide();
                        }
                        else if (userType.compareTo("Staff") == 0) {
                            Admin admin = new Admin("**ADMIN MENU**", Main.menu);
                            admin.setWidth(500);
                            admin.setHeight(700);
                            hide();
                        }
                    } else {
                        fail.setText("Incorrect password!");
                    }
                } else {
                    fail.setText("This username does not exist!");
                }
            }
        }
    }
}
