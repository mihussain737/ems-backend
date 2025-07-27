package net.mihussain.ems.controller;

import net.mihussain.ems.EmsBackendApplication;
import net.mihussain.ems.dto.DepartmentDto;
import net.mihussain.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        EmsBackendApplication.logger.info("Inside createDepartment method ::departmentDto {}", departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription());
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentWithId(@PathVariable("id") Long departmentId) {
        EmsBackendApplication.logger.info("Inside getDepartmentWithId method ::departmentId {}", departmentId);
        DepartmentDto department = departmentService.getDeparmentById(departmentId);
        EmsBackendApplication.logger.info("Department found {} with name:"+ department.getDepartmentName());
        return ResponseEntity.ok(department);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departmentDtoList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>("Department deleted with id " + departmentId + " successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto departmentDto) {
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }
}
