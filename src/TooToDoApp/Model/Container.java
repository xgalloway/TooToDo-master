package TooToDoApp.Model;

import java.util.ArrayList;

/**
 * A container class that holds all users of application and the current user
 * of the application
 */
public class Container {
    private ArrayList<User> users = new ArrayList<User>();
    private User currentUser;

    public Container() {
    }

    /**
     * Setter for current user
     * @param currentUser the current user of the application
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * Getter for current user
     * @return current user of the application
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Getter for array list of users.
     * @return array list of users.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Adds new user to array list of users
     * @param newUser new user to add to the array list of users
     */
    public void addUser(User newUser) {
        users.add(newUser);
    }

    /**
     * This method checks the list of users and returns the index of the user within
     * the array list
     * @param userName username to check whether it exists within the list or not
     * @return index of user within the array list, -1 otherwise.
     */
    public int userIndex(String userName) {
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                if (userName.equalsIgnoreCase(users.get(i).getUserName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param index index of user to check password
     * @param password password given by user to check
     * @return true if the password and username coincide, false otherwise.
     */
    public boolean passwordMatch(int index, String password) {
        return users.get(index).getPassword().equals(password);
    }
}
