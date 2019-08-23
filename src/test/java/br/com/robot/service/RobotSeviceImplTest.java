package br.com.robot.service;

import br.com.robot.enums.Direction;
import br.com.robot.model.Robot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotSeviceImplTest {

    @Autowired
    RobotSevice robotSevice;

    @Test(expected = Exception.class)
    public void routeInvalidReturnExeption() throws Exception {
        robotSevice.run("AAAAA");
    }

    @Test(expected = Exception.class)
    public void offRouteReturnExeption() throws Exception {
        robotSevice.run("MMLM");
    }

    @Test
    public void routeReturnValid() throws Exception {
        Robot robot = robotSevice.run("MML");
        assertEquals(robot, new Robot(0,2, Direction.W));
    }

    @Test
    public void routeReturnValid2() throws Exception {
        Robot robot = robotSevice.run("MMRMMRMM");
        assertEquals(robot, new Robot(2,0, Direction.S));
    }

    @Test
    public void routeReturnValid3() throws Exception {
        Robot robot = robotSevice.run("MMMMRMMMMRMMMMRMMMMR");
        assertEquals(robot, new Robot(0,0, Direction.N));
    }

    @Test
    public void routeReturnValid4() throws Exception {
        Robot robot = robotSevice.run("RMMMMLMLMMMMRMRMMMMLMLMMMMRMRMMMMR");
        assertEquals(robot, new Robot(4,4, Direction.S));
    }
}