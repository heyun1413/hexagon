package pub.ron.hexagon.dto;

import org.springframework.util.StringUtils;

public class Error {

    private String message;

    private Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Error from(String message) {
        if (StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("message is not null");
        }
        return new Error(message);
    }
}
