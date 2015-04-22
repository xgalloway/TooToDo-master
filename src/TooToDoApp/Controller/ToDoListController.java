package TooToDoApp.Controller;

import TooToDoApp.Model.ToDo;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class for the main To Do List screen.
 */
public class ToDoListController {
    @FXML
    private TableView<ToDo> toDoTable;
    @FXML
    private TableColumn<ToDo, String> doneColumn;
    @FXML
    private TableColumn<ToDo, String> taskColumn;
    @FXML
    private TableColumn<ToDo, String> taskNotesColumn;

    private TooToDoMain main;

    @FXML
    private void initialize() {
        doneColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("doneString"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("taskName"));
        taskNotesColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("taskNotes"));
    }

    /**
     * Handles the create task button by sending the user to the create task screen
     */
    @FXML
    public void handleCreateTask() {
        main.showCreateTask();
    }

    @FXML
    public void handleLogout() {
        main.getContainer().setCurrentUser(null);
        main.showLogin();
    }

    /**
     * Upon selecting the complete task button, the method is called and sets the complete
     * boolean value of the task to true.
     */
    @FXML
    public void handleCompleteTask() {
        int selectedIndex = toDoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            main.getContainer().getCurrentUser().getToDoList().get(selectedIndex).setComplete(true);
            main.showToDoList();
        }
    }

    /**
     * Upon selecting the delete task button, the method is called and removes the
     * selected task from the list.
     */
    @FXML
    public void handleDeleteTask() {
        int selectedIndex = toDoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            main.getContainer().getCurrentUser().getToDoList().remove(selectedIndex);
        }
    }

    /**
     * sets TooToDoMain in order interact with the views
     * @param main the TooToDoMain class that called the controller
     */
    public void setMain(TooToDoMain main) {
        this.main = main;

        toDoTable.setItems(main.getContainer().getCurrentUser().getToDoList());
    }
}
