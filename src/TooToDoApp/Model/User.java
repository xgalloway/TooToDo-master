package TooToDoApp.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * User class which contains the username, password, and to do list.
 */
public class User {
    private String UserName = "";
    private String Password = "";
    private ObservableList<ToDo> toDoList;

    public User(String name, String pw) {
        setUserName(name);
        setPassword(pw);
        toDoList = FXCollections.observableArrayList();
    }

    /**
     * setter for password
     * @param pw password to set to
     */
    public void setPassword(String pw) {
        Password = pw;
    }

    /**
     * setter for username
     * @param name username to set to.
     */
    public void setUserName(String name) {
        UserName = name;
    }

    /**
     * Getter for UserName
     * @return the username of the user
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * Getter for password of user
     * @return the password of user
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Getter for To Do list.
     * @return the observablelist to do list.
     */
    public ObservableList<ToDo> getToDoList() {
        return toDoList;
    }

    /**
     * adds a task to users to do list
     * @param newTask task to add to to do list.
     */
    public void addTask(ToDo newTask) {
        toDoList.add(newTask);
    }
}
