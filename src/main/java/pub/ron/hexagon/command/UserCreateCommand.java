package pub.ron.hexagon.command;

public class UserCreateCommand implements Command {

    private final String username;

    private final String password;


    public UserCreateCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
