package alekseev.test.taskmanagement.mapper;

import alekseev.test.taskmanagement.dto.UserRegistrationDto;
import alekseev.test.taskmanagement.entity.User;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public User convertToEntity (UserRegistrationDto userRegistrationDto){
        return new User(userRegistrationDto.getLogin(), userRegistrationDto.getPassword());
    }
}
