package ruwanpathiranatc.LKBANK.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ruwanpathiranatc.LKBANK.dto.UserDto;
import ruwanpathiranatc.LKBANK.entity.User;
import ruwanpathiranatc.LKBANK.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    public User registerUser(UserDto userDto) {
        User user = mapToUser(userDto);
        return userRepository.save(user);
    }

    private User mapToUser(UserDto userDto) {
        User user = new User();
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setTag("io_" + userDto.getUserName());
        user.setDob(userDto.getDob());
        user.setRoles(List.of("ROLE_USER"));
        return user;
    }

    public Map<String,Object> authenticateUser(UserDto userDto){
        Map<String,Object> authObject = new HashMap<String,Object>();
        User user = (User) userDetailsService.loadUserByUsername(userDto.getUserName());
        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + userDto.getUserName());
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUserName(),
                        userDto.getPassword()
                )
        );
        authObject.put("token","Bearer".concat(jwtService.generateToken(userDto.getUserName())));
        authObject.put("user",user);
return authObject;


    }
}
