package TooToDo;

import java.util.ArrayList;

public class TooToDoModel {
    private ArrayList<User> users;
    private static User currentUser;

    public TooToDoModel() {
        users = new ArrayList<User>();
        currentUser = null;
        System.out.println("Model created");
    }

    public static void setCurrentUser(User currUser) {
        currentUser = currUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addToUsers(User newUser) {
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
}
