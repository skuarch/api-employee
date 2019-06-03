package app.api.model.logic;

import app.api.model.dto.EmployeeDto;
import app.api.model.entity.Employee;
import app.api.model.mappers.EmployeeMapper;
import app.api.model.mappers.CustomEmployeeMapper;
import app.api.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLogic {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeDto getEmployee(Long employeeId) {

        // employee exits?
        if (!employeeService.exitsEmployee(employeeId)) {
            employeeService.throwEmployeeNotFound("employee with id:" + employeeId + " not found");
        }

        // get employee
        Employee employee = employeeService.getEmployee(employeeId);

        // map employee to dto        
        EmployeeDto dto = new CustomEmployeeMapper().entityToDto(employee);

        return dto;

    }

    public List<EmployeeDto> getEmployees() {

        // get employees list
        List<Employee> employees = employeeService.getEmployees();

        // Map employees to dto         
        List<EmployeeDto> dtos = employeeService.entityListToDtoList(employees);

        return dtos;

    }
    
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        
        // convert dto to entity
        Employee employee = EmployeeMapper.MAP.dtoToEntity(employeeDto);
        
        // create new employee
        Employee newEmployee =  employeeService.saveEmployee(employee);
        
        // switch back to dto now with id
        EmployeeDto dto = new CustomEmployeeMapper().entityToDto(newEmployee);
        
        return dto;
        
    }    
    
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        
        if(employeeDto.getId() == null || employeeDto.getId() < 1) {
            throw new IllegalArgumentException("id is null or less than 1");
        }
        
        // convert dto to entity
        Employee employee = EmployeeMapper.MAP.dtoToEntity(employeeDto);
        
        // update new employee
        Employee newEmployee =  employeeService.saveEmployee(employee);
        
        // switch back to dto now with id
        EmployeeDto dto = new CustomEmployeeMapper().entityToDto(newEmployee);
        
        return dto;
        
    }    
    
    public EmployeeDto deleteEmployee(Long employeeId) {
        
        // get employee
        Employee employee = employeeService.getEmployee(employeeId);

        // change status to inactive
        employeeService.inactiveEmployee(employee);
        
        // map to dto
        EmployeeDto dto = employeeService.entityToDto(employee);
        
        return dto;
        
    }

}
