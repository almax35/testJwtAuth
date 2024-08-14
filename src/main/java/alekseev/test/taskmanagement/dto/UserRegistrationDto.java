package alekseev.test.taskmanagement.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String login;
    private String password;
    private String verifyPassword;
}
