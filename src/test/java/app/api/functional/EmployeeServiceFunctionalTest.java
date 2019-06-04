package app.api.functional;

import app.api.model.entity.Employee;
import app.api.service.EmployeeService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeServiceFunctionalTest {
    
    @Autowired
    private EmployeeService employeeService;

    public EmployeeServiceFunctionalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {        
        assertNotNull(employeeService);
    }

    @After
    public void tearDown() {
    }

    // positive
    @Test
    public void testGetEmployee1() throws Exception {

        // given
        Employee employee = employeeService.getEmployee(100L);

        // when
        employee.setLastName("new last name");
        Employee newemployee = employeeService.updateEmployee(employee);

        // then 
        assertEquals(newemployee.getLastName(), "new last name");

    }

}
