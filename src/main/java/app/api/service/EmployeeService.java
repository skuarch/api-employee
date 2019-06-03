package app.api.service;

import app.api.config.exeception.EmployeeNotFoundException;
import app.api.model.dto.EmployeeDto;
import app.api.model.entity.Employee;
import app.api.model.mappers.CustomEmployeeMapper;
import app.api.model.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployee(Long employeeId) {

        if (exitsEmployee(employeeId)) {
            return employeeRepository.getOne(employeeId);
        } else {
            throw new EmployeeNotFoundException("employee not found");
        }

    }

    public Boolean exitsEmployee(Long employeeId) {

        Employee result = employeeRepository.existsEmployee(employeeId);
        Boolean flag = result != null;
        return flag;

    }

    public void throwEmployeeNotFound(String message) {
        throw new EmployeeNotFoundException(message);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId() < 1) {
            throw new IllegalArgumentException("id is null or less than 0");
        }
        return employeeRepository.save(employee);
    }

    public void inactiveEmployee(Employee employee) {

        if (employee.getId() == null || employee.getId() < 1) {
            throw new IllegalArgumentException("id is null or less than 0");
        }

        employee.setStatus(false);
        updateEmployee(employee);
    }

    public List<EmployeeDto> entityListToDtoList(List<Employee> employees) {
        List<EmployeeDto> dtos = new CustomEmployeeMapper()
                .entityListToDtoList(employees);
        return dtos;
    }

    public EmployeeDto entityToDto(Employee employee) {
        return new CustomEmployeeMapper().entityToDto(employee);
    }

}
