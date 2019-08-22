package br.com.robot.utils;

import br.com.robot.enums.Direction;
import br.com.robot.model.Robot;

public class Command {

    public static void getMove (Robot robot) {
        if (robot.getDirection().equals(Direction.N))
            robot.setY(robot.getY() + 1);

        else if (robot.getDirection().equals(Direction.S))
            robot.setY(robot.getY() - 1);

        else if (robot.getDirection().equals(Direction.E))
            robot.setX(robot.getX() + 1);

        else if (robot.getDirection().equals(Direction.W))
            robot.setX(robot.getX() - 1);
    }

    public static void getLeft(Robot robot) {
        if (robot.getDirection().equals(Direction.N))
            robot.setDirection(Direction.W);

        else if (robot.getDirection().equals(Direction.W))
            robot.setDirection(Direction.S);

        else if (robot.getDirection().equals(Direction.S))
            robot.setDirection(Direction.E);

        else if (robot.getDirection().equals(Direction.E))
            robot.setDirection(Direction.N);
    }

    public static void getRight(Robot robot) {
        if (robot.getDirection().equals(Direction.N))
            robot.setDirection(Direction.E);

        else if (robot.getDirection().equals(Direction.E))
            robot.setDirection(Direction.S);

        else if (robot.getDirection().equals(Direction.S))
            robot.setDirection(Direction.W);

        else if (robot.getDirection().equals(Direction.W))
            robot.setDirection(Direction.N);
    }
}
