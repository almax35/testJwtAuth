package alekseev.test.taskmanagement.service;

import alekseev.test.taskmanagement.dto.UserRegistrationDto;
import alekseev.test.taskmanagement.entity.User;

public interface UserService {
    User getUserByLogin(String username);

    void save(UserRegistrationDto userRegistrationDto);
}
