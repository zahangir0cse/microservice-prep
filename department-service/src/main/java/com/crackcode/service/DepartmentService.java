package com.crackcode.service;

import com.crackcode.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto userDto);

    DepartmentDto get(Long id);
}
