package alekseev.test.taskmanagement.controller;

import alekseev.test.taskmanagement.dto.JwtRequest;
import alekseev.test.taskmanagement.dto.JwtResponse;
import alekseev.test.taskmanagement.dto.UserRegistrationDto;
import alekseev.test.taskmanagement.service.AuthService;
import alekseev.test.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<JwtResponse> creatAuthToken(@RequestBody JwtRequest request) throws BadCredentialsException{
        String token=authService.getToken(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    @PostMapping("/registration")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return ResponseEntity.ok("user is created");
    }
}
