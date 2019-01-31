package pub.ron.hexagon.exception;

public class AuthenticateException extends RuntimeException {

    public AuthenticateException() {
        super("用户名或密码错误");
    }
}
