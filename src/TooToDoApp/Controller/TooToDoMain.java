package TooToDoApp.Controller;

import TooToDoApp.Model.Container;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class of Application
 */
public class TooToDoMain extends Application {

    private Stage primaryStage;

    private Container container = new Container();

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start function which is called at start of the program.
     * @param primaryStage the main stage that will show views
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Too To Do");

        try {
            FXMLLoader loader = new FXMLLoader(TooToDoMain.class.getResource("/TooToDoApp/View/Login.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            LoginController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Shows the To Do List
     */
    public void showToDoList() {
        try {
            FXMLLoader loader = new FXMLLoader(TooToDoMain.class.getResource("/TooToDoApp/View/ToDoList.fxml"));
            BorderPane layout = (BorderPane) loader.load();

            ToDoListController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Shows the registration page
     */
    public void showRegistration() {
        try {
            FXMLLoader loader = new FXMLLoader(TooToDoMain.class.getResource("/TooToDoApp/View/Registration.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            RegistrationController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Shows the create task page
     */
    public void showCreateTask() {
        try {
            FXMLLoader loader = new FXMLLoader(TooToDoMain.class.getResource("/TooToDoApp/View/CreateTask.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            CreateTaskController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Shows the login page
     */
    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(TooToDoMain.class.getResource("/TooToDoApp/View/Login.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            LoginController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Getter for the container
     * @return container
     */
    public Container getContainer() {return container;}
}
