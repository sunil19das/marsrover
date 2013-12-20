package org.sunil.marsrover;
import java.util.ArrayList;
import java.util.List;

import org.sunil.marsrover.constants.MarsRobotsConstants;
import org.sunil.marsrover.vo.MarsRobot;

/**
 * This class is responsible for implementing the logic for MarsRover problem
 * This class also has two properties maxX and maxY
 * 
 * @author Sunil Das Thota
 * 
 */
public class MarsRoverDemo {

	private int maxX;
	private int maxY;
	private int minX;
	private int minY;
	public MarsRoverDemo() {

	}

	public MarsRoverDemo(int maxX, int maxY) {
		this.maxX	=	maxX;
		this.maxY	=	maxY;
		this.minX	=	0;
		this.minY	=	0;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public static void main(String x[]) {

		MarsRoverDemo demo = new MarsRoverDemo(5, 5);
		List<MarsRobot> marsRobots = demo.populateRobots();
		demo.moveRobots(marsRobots);
	}

	/**
	 * This method takes robot sequentially and starts marching them.
	 * 
	 * @param marsRobots
	 */
	public void moveRobots(List<MarsRobot> marsRobots) {

		try {
			for (MarsRobot robot : marsRobots) {
				moveEachRobot(robot);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method moves each robot in a given displacement
	 * 
	 * @param robot
	 */
	public void moveEachRobot(MarsRobot	robot){

		System.out.println("Starting Position::" + robot);

		for (String currentMovement : robot
				.getListOfMovementsFromString()) {

			if (currentMovement.equals(MarsRobotsConstants.ONE_BLOCK)) {
				moveOneBlock(robot);
			} else if (currentMovement.equals(MarsRobotsConstants.LEFT)) {
				pointToLeft(robot);
			} else if (currentMovement
					.equals(MarsRobotsConstants.RIGHT)) {
				pointToRight(robot);
			} else {
				System.out
						.println("Invalid instruction, terminating movement");
				break;
			}

		}
		System.out.println("Final Position::" + robot);

	}
	/**
	 * This method populates a list of robots and returns that list.
	 * 
	 * @return list of MarsRobots
	 */
	public List<MarsRobot> populateRobots() {

		List<MarsRobot> marsRobots = new ArrayList<MarsRobot>();
		MarsRobot robo1 = new MarsRobot(1, 2, MarsRobotsConstants.NORTH,
				"LMLMLMLMM");
		marsRobots.add(robo1);
		MarsRobot robo2 = new MarsRobot(3, 3, MarsRobotsConstants.EAST,
				"MMRMMRMRRM");
		marsRobots.add(robo2);

		return marsRobots;
	}

	/**
	 * This method points the Robot to Left direction(turns 90 degrees to the
	 * left from its current direction).
	 * 
	 * @param robot
	 */
	public void pointToLeft(MarsRobot robot) {
		String currentDirection = robot.getCurrentDirection();
		currentDirection = MarsRobotsConstants.rotateLeftMap
				.get(currentDirection);
		robot.setCurrentDirection(currentDirection);
	}

	/**
	 * This method points the Robot to Right direction(turns 90 degrees to the
	 * right from its current direction).
	 * 
	 * @param robot
	 */
	public void pointToRight(MarsRobot robot) {
		String currentDirection = robot.getCurrentDirection();
		currentDirection = MarsRobotsConstants.rotateRightMap
				.get(currentDirection);
		robot.setCurrentDirection(currentDirection);
	}

	/**
	 * This method moves the robot one block in whatever direction the robot is
	 * in currently. The method throws a runtime exception if by any chance, the
	 * robot goes out of bounds
	 * 
	 * @param robot
	 * @throws RuntimeException
	 */
	public void moveOneBlock(MarsRobot robot) throws RuntimeException {
		if (robot.getCurrentDirection().equals(MarsRobotsConstants.NORTH)) {
			if (robot.getCurrentY() < this.maxY) {
				robot.setCurrentY(robot.getCurrentY() + 1);
			} else
				throw new RuntimeException("Going out of bounds::" + this
						+ "::" + robot);
		} else if (robot.getCurrentDirection().equals(MarsRobotsConstants.EAST)) {
			if (robot.getCurrentX() < this.maxX) {
				robot.setCurrentX(robot.getCurrentX() + 1);
			} else
				throw new RuntimeException("Going out of bounds::" + this
						+ "::" + robot);
		} else if (robot.getCurrentDirection().equals(MarsRobotsConstants.WEST)) {
			if (robot.getCurrentX() > this.minX) {
				robot.setCurrentX(robot.getCurrentX() - 1);
			} else
				throw new RuntimeException("Going out of bounds::" + this
						+ "::" + robot);
		} else if (robot.getCurrentDirection()
				.equals(MarsRobotsConstants.SOUTH)) {
			if (robot.getCurrentY() > this.minY) {
				robot.setCurrentY(robot.getCurrentY() - 1);
			} else
				throw new RuntimeException("Going out of bounds::" + this
						+ "::" + robot);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mars Rover Demo::" + getMaxX() + " " + getMaxY());
		return sb.toString();
	}
}
