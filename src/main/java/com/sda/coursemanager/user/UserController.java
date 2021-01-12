package com.sda.coursemanager.user;

import com.sda.coursemanager.user.model.User;
import com.sda.coursemanager.user.model.dto.UserDto;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not found"));
        return UserMapper.mapUserToUserDto(user);
    }
}