package org.sunil.marsrover.test;
import org.junit.Test;
import org.sunil.marsrover.MarsRoverDemo;
import org.sunil.marsrover.constants.MarsRobotsConstants;
import org.sunil.marsrover.vo.MarsRobot;


public class MarsRoverTest {

	
	@Test
	public void moveEachRobotTest(){
		
		String displace	=	"LMLMLMLMLM";
		int expectedX	=	1;
		int expectedY	=	3;
		String expectedDirection	=	MarsRobotsConstants.NORTH;
		MarsRobot	robot	=	new MarsRobot(1,2,MarsRobotsConstants.NORTH,displace);
		MarsRoverDemo	demo	=	new MarsRoverDemo(5,5);
		demo.moveEachRobot(robot);
		assert(robot.getCurrentX()	==	expectedX);
		assert(robot.getCurrentY()	==	expectedY);
		assert(robot.getCurrentDirection().equals(expectedDirection));
	}
	@Test
	public void moveOneBlockTest(){
		String displace	=	"LMLMLMLMLM";
		MarsRobot	robot	=	new MarsRobot(1,2,MarsRobotsConstants.NORTH,displace);
		MarsRoverDemo	demo	=	new MarsRoverDemo(3,3);
		demo.moveOneBlock(robot);
		assert(robot.getCurrentY()==demo.getMaxY());
		demo.pointToRight(robot);
		demo.moveOneBlock(robot);
		demo.moveOneBlock(robot);
		assert(robot.getCurrentX()==demo.getMaxX());
	}
	@Test(expected=RuntimeException.class)
	public void moveOneBlockExceptionTest() {
		String displace	=	"LMLMLMLMLM";
		MarsRobot	robot	=	new MarsRobot(1,2,MarsRobotsConstants.NORTH,displace);
		MarsRoverDemo	demo	=	new MarsRoverDemo(3,3);
		demo.moveOneBlock(robot);
		demo.moveOneBlock(robot);
		
	}
	@Test
	public void pointToLeftTest() {
		String displace	=	"LMLMLMLMLM";
		MarsRobot	robot	=	new MarsRobot(1,2,MarsRobotsConstants.NORTH,displace);
		MarsRoverDemo	demo	=	new MarsRoverDemo(5,5);
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.WEST));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.SOUTH));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.EAST));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.NORTH));
		
	}
	@Test
	public void pointToRightTest() {
		String displace	=	"LMLMLMLMLM";
		MarsRobot	robot	=	new MarsRobot(1,2,MarsRobotsConstants.NORTH,displace);
		MarsRoverDemo	demo	=	new MarsRoverDemo(5,5);
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.EAST));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.SOUTH));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.WEST));
		demo.pointToLeft(robot);
		assert(robot.getCurrentDirection().equals(MarsRobotsConstants.NORTH));
		
	}

}
