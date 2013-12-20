package org.sunil.marsrover.vo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a POJO class for a MarsRobot
 * It has currentX, currentY, currentDirection, totalDisplacement and listOfMovements as properties.
 * Each of them has a getter and setter.
 * 
 * @author Sunil Das Thota
 *
 */
public class MarsRobot {
	private	int currentX;
	private	int currentY;
	private String currentDirection;
	private String totalDisplacement;
	private List<String>	listOfMovements	=	new ArrayList<String>();
	public MarsRobot(){
		
	}
	public MarsRobot(int currentX, int currentY, String currentDirection, String totalDisplacement){
		this.currentX	=	currentX;
		this.currentY	=	currentY;
		this.currentDirection	=	currentDirection;
		this.totalDisplacement	=	totalDisplacement;
	}
	
	public String getTotalDisplacement() {
		return totalDisplacement;
	}
	public void setTotalDisplacement(String totalDisplacement) {
		this.totalDisplacement = totalDisplacement;
	}
	public int getCurrentX() {
		return currentX;
	}
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}
	public int getCurrentY() {
		return currentY;
	}
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
	public String getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(String currentDirection) {
		this.currentDirection = currentDirection;
	}
	public List<String> getListOfMovementsFromString(){
		listOfMovements	=	Arrays.asList(getTotalDisplacement().split(""));
		return listOfMovements;
	}
	@Override
	public String toString(){
		StringBuilder sb	=	new StringBuilder();
		sb.append("Robot::"+getCurrentX()+" "+getCurrentY()+" "+getCurrentDirection());
		return sb.toString();
	}
}
