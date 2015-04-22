package TooToDoApp.Controller;

import TooToDoApp.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for Registration Page
 */
public class RegistrationController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField retypePasswordField;
    @FXML
    private Label incorrectRegister;

    private TooToDoMain main;

    /**
     * Handles the register button, performs a check as to whether the passwords match
     * and whether the username has already been created.
     */
    @FXML
    public void handleRegisterButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String retypePassword = retypePasswordField.getText();
        if (!password.equals(retypePassword)) {
            incorrectRegister.setText("Passwords do not match.");
            return;
        }
        if (main.getContainer().userIndex(username) > -1) {
            incorrectRegister.setText("Username already exists.");
            return;
        }
        User newUser = new User(username, password);
        main.getContainer().addUser(newUser);
        main.getContainer().setCurrentUser(newUser);
        main.showToDoList();
    }

    /**
     * Handles the cancel button by sending the user back to the login screen.
     */
    @FXML
    public void handleCancelButton() {
        main.showLogin();
    }

    /**
     * sets TooToDoMain in order interact with the views
     * @param main the TooToDoMain class that called the controller
     */
    @FXML
    public void setMain(TooToDoMain main) {
        this.main = main;
    }

}
