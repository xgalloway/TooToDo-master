package TooToDo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Kerry on 3/12/2015.
 */
public class ToDo {
    private final SimpleStringProperty taskName = new SimpleStringProperty("");
    private final SimpleStringProperty taskNotes = new SimpleStringProperty("");
    public final SimpleBooleanProperty isComplete = new SimpleBooleanProperty(false);
    private ObservableList<ToDo> toDoList;

    public ToDo() {
        setTaskName("");
        setTaskNotes("");
        setComplete(false);
    }

    public ToDo(String taskName, String taskNotes, Boolean complete) {
        setTaskName(taskName);
        setTaskNotes(taskNotes);
        setComplete(complete);
        toDoList = FXCollections.observableArrayList();
    }

    public void setTaskName(String name) {
        taskName.set(name);
    }

    public void setTaskNotes(String notes) {
        taskNotes.set(notes);
    }

    public void setComplete(boolean completed) {
        isComplete.set(completed);
    }

    public Boolean getComplete() {
        return isComplete.get();
    }

    public String getTaskNotes() {
        return taskNotes.get();
    }

    public String getTaskName() {
        return taskName.get();
    }

    @Override
    public String toString() {
        return "Task Name: " + getTaskName() + "...Task: " + getTaskNotes();
    }

    public ObservableList<ToDo> getToDoList() {
        return toDoList;
    }

    public void addTask(ToDo newTask) {
        toDoList.add(newTask);
    }

}
