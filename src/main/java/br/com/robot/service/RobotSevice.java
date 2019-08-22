package br.com.robot.service;

import br.com.robot.model.Robot;

public interface RobotSevice {
    Robot run(String route) throws Exception;
}
