package app.api.controller;

import app.api.model.common.EndPoints;
import app.api.model.dto.EmployeeDto;
import app.api.model.logic.EmployeeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.EMPLOYEE)
public class PlayAroundController {
    
    // this class is just to simplify the deletion of the user
    // and don't should be take in evaluation
    
    @Autowired
    private EmployeeLogic employeeLogic;
    
    
    @GetMapping("/delete1")
    public String deleteFirstUser() {    
        employeeLogic.deleteEmployee(1L);
        return "employee 1 deleted (soft delete)";
    }    
    
    @GetMapping("/update1")
    public String updateFirstUser() {    
        EmployeeDto employeeDto = new EmployeeDto(1L, "f", "m","l","2010-10-10","2010-10-10","ACTIVE");
        employeeLogic.updateEmployee(employeeDto);
        return "employee 1 updated";
    }
    
}
