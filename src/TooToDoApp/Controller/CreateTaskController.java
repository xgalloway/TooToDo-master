package TooToDoApp.Controller;

import TooToDoApp.Model.ToDo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateTaskController {
    @FXML
    TextField taskNameField;
    @FXML
    TextField taskNotesField;

    TooToDoMain main;

    public void setMain(TooToDoMain main) {
        this.main = main;
    }

    @FXML
    public void handleCreateTask() {
        String taskName = taskNameField.getText();
        String taskNotes = taskNotesField.getText();
        main.getContainer().getCurrentUser().addTask(new ToDo(taskName, taskNotes));
        main.showToDoList();
    }

    @FXML
    public void handleCancel() {
        main.showToDoList();
    }
}
