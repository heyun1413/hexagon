package pub.ron.hexagon.domain.model;

import pub.ron.hexagon.domain.BaseModel;
import pub.ron.hexagon.dto.UserDto;
import pub.ron.hexagon.exception.PasswordNotMatchException;

import javax.persistence.Entity;

@Entity
public class User extends BaseModel {


    private String username;

    private String password;


    public User login(String password) {
        if (this.password.equals(password)) {
            return this;
        }
        throw new PasswordNotMatchException();
    }

    public void modifyPassword(String newerPassword) {
        this.password = newerPassword;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserDto toUserDto() {
        return new UserDto(this.username);
    }
}
