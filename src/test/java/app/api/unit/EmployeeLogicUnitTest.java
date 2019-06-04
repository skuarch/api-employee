package app.api.unit;

import app.api.model.dto.EmployeeDto;
import app.api.model.logic.EmployeeLogic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "admin", password = "admin", roles = "USER")
public class EmployeeLogicUnitTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private EmployeeLogic employeeLogic;

    public EmployeeLogicUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        assertNotNull(mockMvc);
        assertNotNull(employeeLogic);
    }

    @After
    public void tearDown() {
    }

    // positive
    @Test    
    public void testCreateEmployee1() throws Exception {
        
        // given
        EmployeeDto dto = new EmployeeDto();
        dto.setBirthDate("2000-10-10");
        dto.setEmploymentDate("2000-10-10");
        dto.setFirstName("firstName");
        dto.setLastName("lastName");
        dto.setMiddleInitial("l");
        dto.setStatus("ACTIVE");
        
        // when
        EmployeeDto dto2 = employeeLogic.createEmployee(dto);
        
        // then
        assertNotNull(dto2);
        
    }
    
    // negative
    @Test(expected = IllegalArgumentException.class)
    public void testCreateEmployee2() throws Exception {
        
        // given
        EmployeeDto dto = new EmployeeDto();
        dto.setBirthDate("");        
        
        // when
        employeeLogic.createEmployee(dto);
        
        // then
        // an exception should be thrown
        
    }
    
    // negative
    @Test(expected = IllegalArgumentException.class)
    public void testCreateEmployee3() throws Exception {
        
        // given
        EmployeeDto dto = new EmployeeDto();
        dto.setBirthDate(null);  
        
        // when
        employeeLogic.createEmployee(dto);
        
        // then
        // an exception should be thrown
        
    }
    
    // negative
    @Test(expected = IllegalArgumentException.class)
    public void testCreateEmployee4() throws Exception {
        
        // given
        EmployeeDto dto = new EmployeeDto();
        dto.setBirthDate("aaaaaaa");  
        
        // when
        employeeLogic.createEmployee(dto);
        
        // then
        // an exception should be thrown
        
    }
    
}
