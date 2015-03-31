package TooToDoApp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
     * Handles Login Button
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
     * @param main, setter for main
     */
    public void setMain(TooToDoMain main) {
        this.main = main;
    }

}
