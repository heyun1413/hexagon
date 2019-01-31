package pub.ron.hexagon.command;

public class PasswordModifyCommand implements Command {

    private final Long id;

    private final String newerPassword;


    public PasswordModifyCommand(Long id, String newerPassword) {
        this.id = id;
        this.newerPassword = newerPassword;
    }

    public Long getId() {
        return id;
    }

    public String getNewerPassword() {
        return newerPassword;
    }
}
