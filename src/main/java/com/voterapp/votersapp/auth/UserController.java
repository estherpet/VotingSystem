package com.voterapp.votersapp.auth;

import com.voterapp.votersapp.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<AuthRegistrationResponse> register(@RequestBody AuthRegistrationRequest registerUserRequest) {
        log.info("hello");
        try {
            AuthRegistrationResponse response = userService.register(registerUserRequest);
            log.info("response:: {}", response);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception exception) {
            exception.printStackTrace();
            AuthRegistrationResponse response = new AuthRegistrationResponse(5L,"timmy");
            response.setMessage(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (UserAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping
    public String register() {
        return "demo";
    }
}

