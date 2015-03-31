package TooToDoApp.Model;

import java.util.ArrayList;

public class Container {
    private ArrayList<User> users = new ArrayList<User>();
    private User currentUser;

    public Container() {
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

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

    public boolean passwordMatch(int index, String password) {
        return users.get(index).getPassword().equals(password);
    }
}
