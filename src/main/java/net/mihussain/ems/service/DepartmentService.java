package net.mihussain.ems.service;

import net.mihussain.ems.dto.DepartmentDto;
import net.mihussain.ems.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDeparmentById(Long id);

    List<DepartmentDto> getAllDepartments();

    void deleteDepartmentById(Long departmentId);

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);
}
