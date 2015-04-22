package TooToDoApp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for Login Screen
 */
public class LoginController {
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginFailed;

    private TooToDoMain main;

    public LoginController() {}

    /**
     * Handles Login Button by checking for valid usernames and passwords,
     * if not valid, show text "Login Failed"
     */
    @FXML
    private void handleLoginButton() {
        String login = loginTextField.getText();
        String password = passwordField.getText();
        int index = main.getContainer().userIndex(login);
        if (index == -1) {
            loginFailed.setText("Login Failed");
        } else if (main.getContainer().passwordMatch(index, password)) {
            main.getContainer().setCurrentUser(main.getContainer().getUsers().get(index));
            main.showToDoList();
        }
    }

    /**
     * Handles Register Button
     */
    @FXML
    private void handleRegisterButton() {
        main.showRegistration();
    }

    /**
     * sets TooToDoMain in order interact with the views
     * @param main the TooToDoMain class that called the controller
     */
    public void setMain(TooToDoMain main) {
        this.main = main;
    }

}
