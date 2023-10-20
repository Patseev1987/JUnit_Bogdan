package seminars.third.tdd;

import java.util.Objects;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;


    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    public boolean isAdmin() {
        return isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {

        isAuthenticate = Objects.equals(this.name, name) &&
                Objects.equals(this.password, password);
        return isAuthenticate;
    }

    public void logout() {
        isAuthenticate = false;
        name = "";
        password = "";
    }
}