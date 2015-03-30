package TooToDo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ToDoListController extends Application {
    @FXML Text loginFailed;
    @FXML TextField usernameField;
    @FXML TextField passwordField;
    @FXML TextField nameField;
    @FXML TextField dateField;
    @FXML TextField notesField;
    @FXML public TableView<ToDo> tableView;

    private static TooToDoModel tooToDoModel;
    private static TooToDoView tooToDoView;

    @Override
    public void start(Stage primaryStage) throws Exception{
        tooToDoModel = new TooToDoModel();
        tooToDoView = new TooToDoView(primaryStage);
    }

    @FXML
    protected void handleLogInButton(ActionEvent event) throws Exception {
        String login = usernameField.getText();
        String password = passwordField.getText();
        int index = tooToDoModel.userIndex(login);
        if (index == -1) {
            loginFailed.setText("Login Failed");
        } else if (tooToDoModel.getUsers().get(index).getPassword().equals(password)) {
            tooToDoModel.setCurrentUser(tooToDoModel.getUsers().get(index));

            Pane myPane = tooToDoView.changePage("main", event);
            setPane(myPane);

            for (int i =0; i < tooToDoModel.getCurrentUser().getToDoList().size(); i++) {
                System.out.println(tooToDoModel.getCurrentUser().getToDoList().get(i));
            }
        }
    }

    @FXML
    protected void handleWantToRegisterButton(ActionEvent event) throws Exception {
        Pane myPane = tooToDoView.changePage("register", event);
        setPane(myPane);
    }

    @FXML
    protected void handleLogoutButton(ActionEvent event) throws Exception {
        tooToDoModel.setCurrentUser(null);

        Pane myPane = tooToDoView.changePage("login", event);
        setPane(myPane);
    }

    @FXML
    protected void handleRegisterButton(ActionEvent event) throws Exception {
        User newUser = new User(usernameField.getText(), passwordField.getText());
        tooToDoModel.addToUsers(newUser);
        tooToDoModel.setCurrentUser(newUser);

        Pane myPane = tooToDoView.changePage("main", event);
        setPane(myPane);
    }

    @FXML
    protected void handleWantToCreateTaskButton(ActionEvent event) throws Exception {
        Pane myPane = tooToDoView.changePage("createTask", event);
        setPane(myPane);
    }

    @FXML
    protected void handleCreateTaskButton(ActionEvent event) throws Exception {
        tooToDoModel.getCurrentUser().addTask((new ToDo(nameField.getText(), notesField.getText(), false)));

        Pane myPane = tooToDoView.changePage("main", event);
        setPane(myPane);
    }

    protected void setPane(Pane myPane) {
        Scene myScene = new Scene(myPane, 500, 500);
        tooToDoView.getPrimaryStage().setScene(myScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
