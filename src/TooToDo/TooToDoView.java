package TooToDo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TooToDoView {
    private String currentPage;
    private User currentUser;

    private Stage primaryStage;

    public TooToDoView(Stage mainStage) throws Exception {
        primaryStage = mainStage;
        try {
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("TooToDoLogin.fxml"));
            Scene myScene = new Scene(myPane, 500, 500);
            primaryStage.setScene(myScene);
        } catch (Exception e) {
            System.out.println(e);
        }
        primaryStage.setTitle("Too To Do");
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Pane changePage(String goTo, ActionEvent event) throws Exception {
        Stage stageEvent = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Pane myPane = null;
        if (goTo.equalsIgnoreCase("login")) {
            myPane = (Pane) FXMLLoader.load(getClass().getResource("TooToDoLogin.fxml"));
            currentPage = "login";
        } else if (goTo.equalsIgnoreCase("register")) {
            myPane = (Pane) FXMLLoader.load(getClass().getResource("ToDoListRegister.fxml"));
            currentPage = "register";
        } else if (goTo.equalsIgnoreCase("main")) {
            myPane = (Pane) FXMLLoader.load(getClass().getResource("ToDoListMain.fxml"));
            currentPage = "main";
        } else if (goTo.equalsIgnoreCase("createTask")) {
            myPane = (Pane) FXMLLoader.load(getClass().getResource("ToDoListCreateTask.fxml"));
        }
        return myPane;
    }

    public void setCurrentUser(User newUser) {
        currentUser = newUser;
    }
}
