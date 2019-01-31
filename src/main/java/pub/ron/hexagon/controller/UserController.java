package pub.ron.hexagon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.ron.hexagon.application.UserApplication;
import pub.ron.hexagon.command.PasswordModifyCommand;
import pub.ron.hexagon.command.UserCreateCommand;
import pub.ron.hexagon.dto.Error;
import pub.ron.hexagon.dto.UserDto;
import pub.ron.hexagon.exception.AuthenticateException;

@RestController
@RequestMapping("/user")
public class UserController {



    private final UserApplication userApplication;

    public UserController(UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(String username,
                                         String password) {
        return ResponseEntity.ok(userApplication.login(username, password));
    }

    @ExceptionHandler({AuthenticateException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error handleAuthenticateFail(AuthenticateException ex) {
        return Error.from(ex.getMessage());
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(String username,
                                      String password) {
        userApplication.create(new UserCreateCommand(username, password));
        return ResponseEntity.ok("创建用户成功");
    }

    @PostMapping("/modify-pwd")
    public ResponseEntity<String> create(Long id,
                                         String password) {
        userApplication.modifyPassword(new PasswordModifyCommand(id, password));
        return ResponseEntity.ok("用户密码修改成功");
    }


}
