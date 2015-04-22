package TooToDoApp.Controller;

import TooToDoApp.Model.ToDo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for the create task page.
 */
public class CreateTaskController {
    @FXML
    TextField taskNameField;
    @FXML
    TextField taskNotesField;

    TooToDoMain main;

    /**
     * When creating a task, the method grabs the values of the text fields and
     * creates a task object to add to the user's list and then shows the to do list.
     */
    @FXML
    public void handleCreateTask() {
        String taskName = taskNameField.getText();
        String taskNotes = taskNotesField.getText();
        main.getContainer().getCurrentUser().addTask(new ToDo(taskName, taskNotes));
        main.showToDoList();
    }

    /**
     * Upon pressing the cancel button the view is changed to the to do list.
     */
    @FXML
    public void handleCancel() {
        main.showToDoList();
    }

    /**
     * sets TooToDoMain in order interact with the views
     * @param main the TooToDoMain class that called the controller
     */
    public void setMain(TooToDoMain main) {
        this.main = main;
    }
}
