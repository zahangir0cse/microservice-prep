package com.crackcode.service.impl;

import com.crackcode.dto.DepartmentDto;
import com.crackcode.entity.Department;
import com.crackcode.repository.DepartmentRepository;
import com.crackcode.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("departmentService")
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto userDto) {
        log.info("---------- Inside DepartmentService.createDepartment ");
        Department department = modelMapper.map(userDto, Department.class);
        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public DepartmentDto get(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(department, DepartmentDto.class);
    }
}
