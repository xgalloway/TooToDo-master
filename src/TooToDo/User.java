package TooToDo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private String UserName = "";
    private String Password = "";
    private ObservableList<ToDo> toDoList;

    public User(String name, String pw) {
        setUserName(name);
        setPassword(pw);
        toDoList = FXCollections.observableArrayList();
    }

    public void setPassword(String pw) {
        Password = pw;
    }

    public void setUserName(String name) {
        UserName = name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public ObservableList<ToDo> getToDoList() {
        return toDoList;
    }

    public void addTask(ToDo newTask) {
        toDoList.add(newTask);
    }
}
