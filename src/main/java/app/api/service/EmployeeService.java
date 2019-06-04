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

    @Autowired
    private EmployeeValidator employeeValidator;

    public Employee getEmployee(Long employeeId) {
        employeeValidator.validateIdAndThrowException(employeeId);
        exitsEmployee(employeeId);
        return employeeRepository.getOne(employeeId);
    }

    public Boolean exitsEmployee(Long employeeId) {
        employeeValidator.validateIdAndThrowException(employeeId);
        Employee result = employeeRepository.existsEmployee(employeeId);
        return result != null;
    }

    public void throwEmployeeNotFound(String message) {
        throw new EmployeeNotFoundException(message);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) { 
        employeeValidator.validatMandatoryFieldsAndThrowException(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        employeeValidator.validateAllFieldsAndThrowException(employee);
        return employeeRepository.save(employee);
    }

    public void inactiveEmployee(Employee employee) {
        employeeValidator.validateAllFieldsAndThrowException(employee);
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
