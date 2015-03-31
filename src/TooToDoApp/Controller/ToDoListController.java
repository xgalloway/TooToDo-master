package TooToDoApp.Controller;

import TooToDoApp.Model.ToDo;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    public void handleCompleteTask() {
        int selectedIndex = toDoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            main.getContainer().getCurrentUser().getToDoList().get(selectedIndex).setComplete(true);
            main.showToDoList();
        }
    }

    @FXML
    public void handleDeleteTask() {
        int selectedIndex = toDoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            main.getContainer().getCurrentUser().getToDoList().remove(selectedIndex);
        }
    }

    public void setMain(TooToDoMain main) {
        this.main = main;

        toDoTable.setItems(main.getContainer().getCurrentUser().getToDoList());
    }
}
