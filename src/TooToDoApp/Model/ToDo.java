package TooToDoApp.Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A class to represent each task that needs to be done by the user
 */
public class ToDo {
    private String taskName;
    private String taskNotes;
    //doneString is the string that shows in the To Do List that tells
    //whether or not the task is complete or not.
    private String doneString;
    public Boolean isComplete;

    public ToDo() {
        setTaskName("");
        setTaskNotes("");
        setComplete(false);
    }

    public ToDo(String taskName, String taskNotes) {
        setTaskName(taskName);
        setTaskNotes(taskNotes);
        setComplete(false);
    }

    /**
     * Setter for task name
     * @param taskName task name to be used
     */
    public void setTaskName(String taskName) { this.taskName = taskName;}

    /**
     * Setter for task notes
     * @param taskNotes task notes to be used
     */
    public void setTaskNotes(String taskNotes) { this.taskNotes = taskNotes; }

    /**
     * Setter for task name
     * @param isComplete whether a task is complete or not, also sets string value
     */
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
        doneString = (isComplete) ? "Done!" : "No";
    }

    /**
     * Getter for isComplete
     * @return boolean value of whether task is complete or not
     */
    public Boolean getComplete() {
        return isComplete;
    }

    /**
     * Getter for taskNotes
     * @return String value of task notes
     */
    public String getTaskNotes() {
        return taskNotes;
    }

    /**
     * Getter for taskName
     * @return boolean value of task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Getter for doneString
     * @return string value of the string that shows in list
     */
    public String getDoneString() {
        return doneString;
    }
}
