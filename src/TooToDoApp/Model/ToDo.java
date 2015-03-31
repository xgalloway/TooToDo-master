package TooToDoApp.Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDo {
    private String taskName;
    private String taskNotes;
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

    public void setTaskName(String taskName) { this.taskName = taskName;}

    public void setTaskNotes(String taskNotes) { this.taskNotes = taskNotes; }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
        doneString = (isComplete) ? "Done!" : "No";
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDoneString() {
        return doneString;
    }
}
