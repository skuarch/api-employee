package app.api.controller;

import app.api.model.common.EndPoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.INDEX)
public class IndexController {
    
    @GetMapping
    public String index() {    
        return "<br/><br/>hello to api-employee <br/><br/>"
                + "<a href='http://localhost:8080/h2'>H2 console</a><br/>"
                + "<a href='http://localhost:8080/swagger-ui.html'>swagger documentation</a><br/><br/>"
                + "<a href='http://localhost:8080/employee'>get all employees</a><br/>"
                + "<a href='http://localhost:8080/employee/1'>get first employee </a><br/>"                
                + "<a href='http://localhost:8080/employee/update1'>update first employee </a><br/>"
                + "<a href='http://localhost:8080/employee/delete1'>delete first employee </a><br/>";                  
        
    }
    
}
