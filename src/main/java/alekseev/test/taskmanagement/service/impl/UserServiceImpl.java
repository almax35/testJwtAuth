package alekseev.test.taskmanagement.service.impl;

import alekseev.test.taskmanagement.dto.UserRegistrationDto;
import alekseev.test.taskmanagement.entity.Role;
import alekseev.test.taskmanagement.entity.User;
import alekseev.test.taskmanagement.mapper.UserMapper;
import alekseev.test.taskmanagement.repository.RoleRepository;
import alekseev.test.taskmanagement.repository.UserRepository;
import alekseev.test.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User getUserByLogin(String username) {
        return userRepository.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserRegistrationDto userRegistrationDto) {
        userRegistrationDto.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        User user=userMapper.convertToEntity(userRegistrationDto);
        Optional<Role> optionalRole=roleRepository.findByName("ROLE_USER");
        if (optionalRole.isPresent()){
            user.setRole(optionalRole.get());
            userRepository.save(user);
        } else {
            throw new DataSourceLookupFailureException("");
        }

    }


}
