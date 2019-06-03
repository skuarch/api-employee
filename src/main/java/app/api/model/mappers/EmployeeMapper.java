package app.api.model.mappers;

import app.api.model.dto.EmployeeDto;
import app.api.model.entity.Employee;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    EmployeeMapper MAP = Mappers.getMapper(EmployeeMapper.class);    
    EmployeeDto entityToDto(Employee employee);    
    
    @InheritInverseConfiguration
    Employee dtoToEntity(EmployeeDto employeeDto);    
    
    @IterableMapping(dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<EmployeeDto> entityListToDtoList(List<Employee> employees);    
}
