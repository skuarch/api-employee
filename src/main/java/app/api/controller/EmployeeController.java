package app.api.controller;

import app.api.model.common.EndPoints;
import app.api.model.dto.EmployeeDto;
import app.api.model.logic.EmployeeLogic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.EMPLOYEE)
public class EmployeeController {
    
    @Autowired
    private EmployeeLogic employeeLogic;
    
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(employeeLogic.getEmployees());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeLogic.getEmployee(id));
    }
    
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeLogic.createEmployee(employeeDto));
    }
    
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeLogic.updateEmployee(employeeDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeLogic.deleteEmployee(id));
    }
    
}
