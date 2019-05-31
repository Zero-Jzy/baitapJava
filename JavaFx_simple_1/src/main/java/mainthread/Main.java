package mainthread;

import entity.User;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.UserModel;


public class Main extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");
        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));


        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0, 1);


        TextField nameField = new TextField();
        gridPane.add(nameField, 1, 1);


        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 0, 2);

        TextField emailField = new TextField();
        gridPane.add(emailField, 1, 2);


        Label usernamelabel = new Label("User Name : ");
        gridPane.add(usernamelabel, 0, 3);

        TextField usernameField = new TextField();
        gridPane.add(usernameField, 1, 3);


        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 4);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 4);


        Label confirmPasswordLabel = new Label("Confirm Password : ");
        gridPane.add(confirmPasswordLabel, 0, 5);

        PasswordField confirmPasswordField = new PasswordField();
        gridPane.add(confirmPasswordField, 1, 5);


        Label phonelabel = new Label("Phone : ");
        gridPane.add(phonelabel, 0, 6);

        TextField phoneFiels = new TextField();
        gridPane.add(phoneFiels, 1, 6);


        Button submitButton = new Button("Submit");

        gridPane.add(submitButton, 1, 7);


        submitButton.setOnAction(event ->{

            User user = new User();

            user.setName(nameField.getText());
            user.setEmail(emailField.getText());
            user.setUsername(usernameField.getText());
            user.setPassword(passwordField.getText());
            user.setPhone(passwordField.getText());

            UserModel model = new UserModel();
            if(model.register(user)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Register successfull");
                alert.setContentText("Hello");
                alert.show();
            }
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}