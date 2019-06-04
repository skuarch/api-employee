package app.api.model.mappers;

import app.api.model.dto.EmployeeDto;
import app.api.model.entity.Employee;
import java.util.ArrayList;
import java.util.List;

public class CustomEmployeeMapper implements EmployeeMapper {

    @Override
    public EmployeeDto entityToDto(Employee employee) {
        
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setBirthDate(employee.getBirthDate());
        dto.setEmploymentDate(employee.getEmploymentDate());
        dto.setFirstName(employee.getFirstName());
        dto.setId(employee.getId());
        dto.setLastName(employee.getLastName());
        dto.setMiddleInitial(employee.getMiddleInitial());

        if (employee.getStatus()) {
            dto.setStatus("ACTIVE");
        } else {
            dto.setStatus("INACTIVE");
        }
        
        return dto;

    }

    @Override
    public Employee dtoToEntity(EmployeeDto employeeDto) {
        
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setEmploymentDate(employeeDto.getEmploymentDate());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setId(employeeDto.getId());
        employee.setLastName(employeeDto.getLastName());
        employee.setMiddleInitial(employeeDto.getMiddleInitial());

        if (employeeDto.getStatus().equalsIgnoreCase("ACTIVE")) {
            employee.setStatus(true);
        } else {
            employee.setStatus(false);
        }
        
        return employee;
    }

    @Override
    public List<EmployeeDto> entityListToDtoList(List<Employee> employees) {
        
        List<EmployeeDto> dtos = new ArrayList<>();
        
        employees.forEach((employee) -> {
            dtos.add(entityToDto(employee));
        });
        
        return dtos;
        
    }

}
