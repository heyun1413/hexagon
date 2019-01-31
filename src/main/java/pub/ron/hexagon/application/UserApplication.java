package pub.ron.hexagon.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.ron.hexagon.command.PasswordModifyCommand;
import pub.ron.hexagon.command.UserCreateCommand;
import pub.ron.hexagon.domain.UserRepository;
import pub.ron.hexagon.domain.model.User;
import pub.ron.hexagon.dto.UserDto;
import pub.ron.hexagon.exception.ResourceNotFoundException;
import pub.ron.hexagon.exception.UnknownUserException;

import java.util.Optional;

@Component
public class UserApplication {

    private final UserRepository userRepository;

    @Autowired
    public UserApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(UserCreateCommand userCreateCommand) {
        User user = new User();
        user.setUsername(userCreateCommand.getUsername());
        user.setPassword(userCreateCommand.getPassword());
        userRepository.save(user);
    }

    public UserDto login(String username, String password) {
        return userRepository.findByUsername(username)
                .orElseThrow(UnknownUserException::new)
                .login(password)
                .toUserDto();
    }

    public void modifyPassword(PasswordModifyCommand passwordModifyCommand) {
        Optional<User> optionalUser = userRepository.findById(passwordModifyCommand.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.modifyPassword(passwordModifyCommand.getNewerPassword());
            userRepository.save(user);
        }
        throw new ResourceNotFoundException();
    }

}
