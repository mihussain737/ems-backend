package net.mihussain.ems.service.impl;

import lombok.AllArgsConstructor;
import net.mihussain.ems.dto.EmployeeDto;
import net.mihussain.ems.entity.Employee;
import net.mihussain.ems.exception.ResourceNotFoundException;
import net.mihussain.ems.mapper.EmployeeMapper;
import net.mihussain.ems.repository.EmployeeRepository;
import net.mihussain.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not found with id :" + employeeId)
        );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployee = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = allEmployee.stream().map(one -> EmployeeMapper.mapToEmployeeDto(one)).toList();
        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not found with id :" + employeeId)
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee Not found with id :" + employeeId)
        );
        employeeRepository.delete(employee);
    }

}
