package br.com.robot.service;

import br.com.robot.controller.RobotController;
import br.com.robot.enums.Direction;
import br.com.robot.model.Robot;
import br.com.robot.utils.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RobotSeviceImpl implements RobotSevice {

    private static final Logger logger =  LoggerFactory.getLogger(RobotController.class);

    @Value("${mars.size.x}")
    private int marsSizeX;

    @Value("${mars.size.y}")
    private int marsSizeY;

    @Override
    public Robot run(String route) throws Exception {

        String errror;
        String[] routes = route.split("");

        if (validate(routes)) {
            errror = "Rota Inválida";
            logger.info(errror);
            throw new Exception(errror);
        }

        Robot robot = new Robot(0,0, Direction.N);
        logger.info(robot.toString());

        for (String r : routes) {
            if (r.equals("R"))
                Command.getRight(robot);
            else if (r.equals("L"))
                Command.getLeft(robot);
            else
                Command.getMove(robot);

            logger.info(String.format("move %s: %s", r, robot.toString()));
            if (robot.getX() >= 0 && robot.getX() < marsSizeX &&
                    robot.getY() >= 0 && robot.getY() < marsSizeY)
                continue;

            errror = "Robô fora da rota";
            logger.info(errror);
            throw new Exception(errror);
        }

        return robot;
    }

    private Boolean validate(String[] routes) {
        for (String s : routes) {
            if (s.equals("R") || s.equals("L") || s.equals("M"))
                continue;
            return true;
        }
        return false;
    }
}