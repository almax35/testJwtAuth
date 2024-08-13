package alekseev.test.taskmanagement.service.impl;

import alekseev.test.taskmanagement.entity.User;
import alekseev.test.taskmanagement.repository.UserRepository;
import alekseev.test.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User getUserByLogin(String username) {
        return userRepository.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
