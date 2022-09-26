package com.crackcode.service.impl;

import com.crackcode.dto.DepartmentDto;
import com.crackcode.dto.UserDto;
import com.crackcode.dto.UserResponseDto;
import com.crackcode.entity.User;
import com.crackcode.repository.UserRepository;
import com.crackcode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("---------- Inside UserService.createUser ");
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserResponseDto get(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponseDto userResponseDto = new UserResponseDto();
        if(user != null){
            DepartmentDto departmentDto = restTemplate.getForObject("http://department-service/api/v1/departments/" + user.getDepartmentId(), DepartmentDto.class);
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userResponseDto.setUser(userDto);
            userResponseDto.setDepartment(departmentDto);
        }
        return userResponseDto;
    }
}
