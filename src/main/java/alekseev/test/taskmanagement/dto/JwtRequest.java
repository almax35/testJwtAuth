package alekseev.test.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class JwtRequest {
    private String login;
    private String password;

}
