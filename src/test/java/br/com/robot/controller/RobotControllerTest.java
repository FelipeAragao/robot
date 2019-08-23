package br.com.robot.controller;

import br.com.robot.service.RobotSeviceImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RobotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void routeValidReturnStatusCode200() throws Exception {
        String routes = "MMRMMRMM";
        mockMvc.perform(post("/rest/mars/{routes}", routes))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void offRouteReturnStatus400() throws Exception {
        String routes = "MMMMMMMMMMMMMMM";
        mockMvc.perform(post("/rest/mars/{routes}", routes))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void offRouteReturnStatus404() throws Exception {
        String routes = "";
        mockMvc.perform(post("/rest/mars/{routes}", routes))
                .andExpect(status().isNotFound());
    }

    @Test
    public void routeInvalidReturnStatus400() throws Exception {
        String routes = "MLMLMLLMMMM";
        mockMvc.perform(post("/rest/mars/{routes}", routes))
                .andExpect(status().isBadRequest());
    }
}