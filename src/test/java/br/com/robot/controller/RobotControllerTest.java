package br.com.robot.controller;

import br.com.robot.service.RobotSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RobotController.class)
public class RobotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RobotSevice robotSevice;

    @Test
    public void index() {
    }
}