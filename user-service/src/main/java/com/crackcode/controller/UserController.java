package com.crackcode.controller;

import com.crackcode.dto.UserDto;
import com.crackcode.dto.UserResponseDto;
import com.crackcode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id){
        return userService.get(id);
    }
}
