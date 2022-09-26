package com.crackcode.service;

import com.crackcode.dto.UserDto;
import com.crackcode.dto.UserResponseDto;
import com.crackcode.entity.User;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserResponseDto get(Long id);
}
