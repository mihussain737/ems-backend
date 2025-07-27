package net.mihussain.ems.service.impl;

import net.mihussain.ems.dto.DepartmentDto;
import net.mihussain.ems.entity.Department;
import net.mihussain.ems.exception.ResourceNotFoundException;
import net.mihussain.ems.mapper.DepartmentMapper;
import net.mihussain.ems.repository.DepartmentRepository;
import net.mihussain.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDeparmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not found with id " + departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        return allDepartments.stream().map(d->DepartmentMapper.mapToDepartmentDto(d)).toList();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + departmentId));
        if(department.getDepartmentName()!=null) {
            departmentRepository.deleteById(departmentId);
        }
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + departmentId));
        if(department.getDepartmentName()!=null) {
            department.setDepartmentName(departmentDto.getDepartmentName());
            department.setDepartmentDescription(departmentDto.getDepartmentDescription());
            return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(department));
        }
        return null;
    }
}
