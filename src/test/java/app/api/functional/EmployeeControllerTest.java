package app.api.functional;

import app.api.model.common.EndPoints;
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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "admin", password = "admin", roles = "USER")
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public EmployeeControllerTest() {
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
    }

    @After
    public void tearDown() {
    }

    // positive
    @Test    
    public void testGetEmployee1() throws Exception {
        this.mockMvc.perform(
                get(EndPoints.EMPLOYEE + "/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());                
    }

    // negative
    @Test    
    public void testGetEmployee2() throws Exception {
        Long employeeId = 100000L;
        this.mockMvc.perform(
                get(EndPoints.EMPLOYEE + "/" + employeeId))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"code\":404,\"message\":\"employee with id:" + employeeId + " not found\"}"));
    }

    // negative
    @Test    
    public void testGetEmployee3() throws Exception {
        this.mockMvc.perform(
                get(EndPoints.EMPLOYEE + "/a"))
                .andExpect(status().is5xxServerError())
                .andExpect(content().json("{\"code\":500,\"message\":\"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \\\"a\\\"\"}"));
    }

    // negative
    @Test    
    public void testGetEmployee4() throws Exception {
        this.mockMvc.perform(
                get(EndPoints.EMPLOYEE + "/2"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"code\":404,\"message\":\"employee with id:2 not found\"}"));
    }
    
    // positive
    @Test    
    public void testGetEmployeeList() throws Exception {
        this.mockMvc.perform(
                get(EndPoints.EMPLOYEE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
                
    }

}
