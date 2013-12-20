package org.sunil.marsrover.constants;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the constants class for the MarsRover Problem.
 * 
 * @author Sunil Das Thota
 *
 */
public class MarsRobotsConstants {
	public static final String NORTH	=	"N";
	public static final String EAST		=	"E";
	public static final String WEST		=	"W";
	public static final String SOUTH	=	"S";
	public static final String LEFT		=	"L";
	public static final String RIGHT	=	"R";
	public static final String ONE_BLOCK	=	"M";
	public static final Map<String, String> rotateLeftMap	=	new HashMap<String,String>(4);
	public static final Map<String, String> rotateRightMap	=	new HashMap<String,String>(4);
	static{
		
		//the rotate left map - key=current direction, value=the current after 90 degrees turn left from current position
		rotateLeftMap.put(NORTH, WEST);
		rotateLeftMap.put(WEST, SOUTH);
		rotateLeftMap.put(SOUTH, EAST);
		rotateLeftMap.put(EAST, NORTH);

		//the rotate right map - key=current direction, value=the current after 90 degrees turn right from current position
		rotateRightMap.put(NORTH, EAST);
		rotateRightMap.put(EAST, SOUTH);
		rotateRightMap.put(SOUTH, WEST);
		rotateRightMap.put(WEST, NORTH);
		
	}
}
