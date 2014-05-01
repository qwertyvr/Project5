/**
 * A turtle for a turtle graphics system.
 */

import java.awt.List;
import java.lang.*;

public class BasicTurtle {

  /**
   * Instance variables
   */
	public int heading;
	public double xcoord;
	public double ycoord;
	public int dist;
	public double prevY;
	public double prevX;
	public int xgrid;
	public int ygrid;

  // Constructors:
 
  /**
   * Create a new Turtle with a random heading and starting
   * at a random position.
   */  
  public BasicTurtle() {
	  setHeading((int) (Math.random()*360));
	  setx(Math.random()*400);
	  sety(Math.random()*400);
  }

  /**
   * Create a new Turtle with specified heading and position
   */ 
  public BasicTurtle (double inith,double x, double y) {
	  setHeading(inith);
	  setx(x);
	  sety(y);
  }

  /**
   * Create a new Turtle with specified heading and 
   * position at the origin (0,0)
   */ 
  public BasicTurtle (double inith) {
	  setHeading(inith);
	  setx(0);
	  sety(0);
  }

  /**
   * Create a new Turtle with heading due north (0 degrees) and 
   * specified position
   */ 
  public BasicTurtle (double x, double y) {
	  setHeading(90);
	  setx(x);
	  sety(y);
  }

  // Commands:

  /**
   * Reset the turtle to x x-coordinate position. 
   */ 
  public void setx (double x) {
	  xcoord = x;
  }

  /**
   * Reset the turtle to y y-coordinate position. 
   */ 
  public void sety (double y) {
	  ycoord = y;
  }  
  
    /**
   * Reset the turtle to tHeading. 
   */ 
  public void setHeading (double tHeading) {
	  heading = (int) ((450 - tHeading) % 360);
	  if (heading < 0) {
		  heading = heading + 360;
	  }
  }

  
  /**
   * Turn right offset degrees. The turtle heading is changed but the
   * turtle position stays the same.  
   * offset can be any positive or negative value.  
   * The calculation is done % 360 degrees.
   * rt is exactly the opposite of lt.
   */ 
  public void rt (int offset) {
	  heading = (heading - offset) % 360;
	  if (heading < 0) {
		  heading = heading + 360;
	  }
  }

  /**
   * Turn left offset degrees. The turtle heading is changed but the
   * turtle position stays the same.  
   * offset can be any positive or negative value.  
   * The calculation is done % 360 degrees.
   * lt is exactly the opposite of rt.
   */
  public void lt (int offset) {
	  heading = (heading + offset) % 360;
	  if (heading < 0)
		  heading = heading + 360;
  }

  /**
   * Move forward dist steps.  fd is exactly the opposite of bk.  The turtle position
   * is changed but the turtle heading stays the same.
   */  
  public void fd (double dist) {
	  prevX = xcoord;
	  prevY = ycoord;
	  xcoord = Math.cos(Math.toRadians(heading)) * dist + xcoord;
	  ycoord = ycoord - Math.sin(Math.toRadians(heading)) * dist;
	  xgrid = (int) (xcoord*(51/400.0));
	  ygrid = (int) (ycoord*(51/400.0));
	  while ((xcoord < 0) || (xcoord >= 400) || (ycoord < 0 ) || (ycoord >= 400)){
		  wrap();
		  fd(dist);
		  
	  }
	  //TurtleWorld.change(prevX, prevY, xcoord, ycoord);
  }
 
  /**
   * Move backward dist steps.  bk is exactly the opposite of fd.  The turtle position
   * is changed but the turtle heading stays the same.
   */   
  public void bk (double dist) {
	  xcoord = (int) (xcoord - Math.cos(Math.toRadians(heading)) * dist);
	  ycoord = (int) (ycoord - Math.sin(Math.toRadians(heading)) * dist);
	  //TurtleWorld.change(prevX, prevY, xcoord, ycoord);
  }

  // Queries:

  /**
   * Current heading of this turtle in degrees, 0 to < 360, with 0 due north.
   */ 
  public double heading () {
    return heading;
  }

  /**
   * Current x position of the turtle.
   */ 
  public double xcor () {
    return xcoord;
  }

  /**
   * Current y position of the turtle.
   */ 
  public double ycor () {
    return ycoord;
  }

  
  /**
   * Takes current line and moves it left/right/up/down, equal to the
   * length or width of the screen according to which direction it left
   * the window, then reprints the new line onto the screen.
   */
  public void wrap() {
	  double slope = (ycoord - prevY)/(xcoord - prevX);
	  if (xcoord >= 400) {
		  if (slope * 400 + ycoord - slope * xcoord >= 400) {
			  prevY -=400;
			  ycoord = prevY;
			  xcoord = prevX;
		  }
		  else if (slope * 400 + ycoord - slope * xcoord < 0) {
			  prevY += 400;
			  ycoord = prevY;
			  xcoord = prevX;
		  }
		  else {
			  prevX -= 400;
			  xcoord = prevX;
			  ycoord = prevY;
		  }
	  }
	  else if (xcoord < 0) {
		  if (slope * 0 + ycoord - slope * xcoord >= 400) {
			  prevY -= 400;
			  ycoord = prevY;
			  xcoord = prevX;
		  }
		  else if (slope * 0 + ycoord - slope * xcoord < 0) {
			  prevY += 400;
			  ycoord = prevY;
			  xcoord = prevX;
		  }
		  else {
			  prevX += 400;
			  xcoord = prevX;
			  ycoord = prevY;
		  }
	  }
	  else if (ycoord < 0) {
		  prevY += 400;
		  ycoord = prevY;
		  xcoord = prevX;
	  }
	  else {
		  prevY -= 400;
		  ycoord = prevY;
		  xcoord = prevX;
	  }
	  //fd(dist);
  }
  
  
}
