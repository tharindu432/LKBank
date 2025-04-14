package ruwanpathiranatc.LKBANK.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruwanpathiranatc.LKBANK.dto.UserDto;
import ruwanpathiranatc.LKBANK.entity.User;
import ruwanpathiranatc.LKBANK.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // Constructor for dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.registerUser(userDto));
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto userDto) {
        var authObject = userService.authenticateUser(userDto);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, (String) authObject.get("token"))
                .body(authObject.get("user"));
    }
}