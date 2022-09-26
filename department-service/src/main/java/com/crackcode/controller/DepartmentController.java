package com.crackcode.controller;

import com.crackcode.dto.DepartmentDto;
import com.crackcode.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public DepartmentDto create(@RequestBody DepartmentDto user){
        return departmentService.createDepartment(user);
    }

    @GetMapping("/{id}")
    public DepartmentDto get(@PathVariable Long id){
        return departmentService.get(id);
    }
}
