/**
 * A Turtle for a Turtle Graphics system.
 */

import java.lang.*;

public class Turtle extends BasicTurtle {

  /**
   * Instance variables
   */      

  //public static Patch[][] patches = new Patch[51][51];
  private TurtleWorld TW;
  private boolean penDown;

  // Constructors:
 
  /**
   * Using a TurtleWorld drawing "context", create a new Turtle 
   * with heading due north (0 degrees), and position at the origin (0,0)
   */  
  public Turtle(TurtleWorld TW) {
    super();
    this.TW = TW;
    penDown = false;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle 
   * with specified heading and position.
   */ 
  public Turtle (TurtleWorld TW, double inith, double x, double y) {
    super(inith,x,y);
    this.TW = TW;
    penDown = false;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle
   * with specified heading and position at the origin (0,0)
   */ 
  public Turtle (TurtleWorld TW, double inith) {
    super(inith);
    this.TW = TW;
    penDown = false;
  }

  /**
   * Using a TurtleWorld drawing "context", create a new Turtle
   * with heading due north (0 degrees) and specified position
   */ 
  public Turtle (TurtleWorld TW, double x, double y) {
    super(x,y);
    this.TW = TW;
    penDown = false;
  }

  // Commands:

   /**
   * set the pen down. 
   */ 
  public void pd () {
    penDown = true;
  } 
  
   /**
   * set the pen up. 
   */ 
  public void pu () {
    penDown = false;
  }

  /**
   * Move forward dist steps.  fd is exactly the opposite of bk.  The Turtle position
   * is changed but the Turtle heading stays the same.
   */  
  public void fd (double dist) {
    super.fd(dist);  

    if (penDown) {
      TW.doDrawLine(prevX,prevY, xcoord,ycoord);   
    }
  }

  // Queries:

  /**
   * Return status of pen.
   */ 
  public boolean isPenDown () {
    return penDown;
  }  
  
  
  /** 
  * postcondition: If there is more than one other Turtle on the same grid "patch" as the
  * requesting turtle, then an arbitrary one of these turtles is returned.
  * If there are no other turtles on the same grid "patch" as the requesting turtle, then
  * a "null" turtle reference is returned
  */ 
  public Turtle oneOfTurtlesHere(int x, int y) {
	  if (TurtleController.patches[x][y].turtleList.size() > 0) {
		  return TurtleController.patches[x][y].turtleList.get(0);
	  }
	  else {
		  return null;
	  }
  }
  
  
  /** 
  * postcondition: returns the number of turtles on the current grid "patch", including 
  * this turtle
  */
  public int numGridTurtles(int x, int y) {
	  return TurtleController.patches[x][y].turtleList.size();
  }
  
  
  /** 
  * postcondition: returns the ith turtle in the grid patch collection
  * sequence, including this turtle, 0 <= i <= numGridTurtles()-1
  * (note that the sequence is indexed starting at 0!)
  */
  public Turtle turtleAt(int g, int j, int i) {
	  if (i > TurtleController.patches[g][j].turtleList.size()) {
		  return null;
	  }
	  else {
		  return TurtleController.patches[g][j].turtleList.get(i);
	  }
  }
  
}
