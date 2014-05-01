import java.math.*;
import java.util.ArrayList;
/**
 * Controller object for the TurtleGraphics system
 */
public class TurtleController {
  
  /**
   * instance variables
   */
  private Turtle t;
  private TurtleWorld TW;
  public static Turtle[] Turtles = new Turtle[100];
  public static int[][] Bumps = new int[51][51];
  public static Patch[][] patches = new Patch[51][51];
  
  
  
  
  /**
   * Updates a patch's number of bumps each iteration.
   */
  public static void bumptest() {
	  for (int i = 0; i < 100; i++) {
		  Turtle turtle1 = Turtles[i];
		  for (int g = i + 1; g < 100; g++) {
			  Turtle turtle2 = Turtles[g];
			  if (turtle1.xcoord == turtle2.xcoord & turtle1.ycoord == turtle2.ycoord) {
				  bumpUpdate(turtle1.xcoord, turtle2.ycoord);
			  }
		  }
	  }
  }
  
  public void turtlebump(Turtle t) {
	  for (int i = 0; i < 100; i++) {
		  Turtle turtle1 = Turtles[i];
		  for (int g = i + 1; g < 100; g++) {
			  Turtle turtle2 = Turtles[g];
			  if (turtle1.xcoord == turtle2.xcoord & turtle1.ycoord == turtle2.ycoord) {
				  
			  }
		  }
	  }
  }
  
  
  
  private static void bumpUpdate(double xcoord, double ycoord) {
	Bumps[(int) xcoord][(int) ycoord] += 1;
}





/**
   * Construct a TurtleController object
   */
  public TurtleController(){
    /**
     * A TurtleController object is created with many Turtles
     * and an associated TurtleWorld context.
     */
    TW = new TurtleWorld();
    for (int i = 0; i < 100; i++) {
    	//TW = new TurtleWorld();
    	Turtles[i] = new Turtle(TW);}
  }
  
  /**
   * The drawStuff method completely draws a series of turtle 
   * shapes.
 * @throws InterruptedException 
   */ 
  public void drawStuff() throws InterruptedException{
    /* 
     * This method uses a Turtle to draw it's own Turtle shapes
     */
	  
    //Turtle[].pu();
    
    TW.startgrid();
    
    
    boolean go = true; 
    
    
    /**
     * loop to keep the turtles going.
     */
    while (go) {
    	for (int i = 0; i < 100; i++) {
    		Turtles[i].pd();
    		//Turtles[i].patches[(int) Turtles[i].xgrid][(int) Turtles[i].ygrid].turtleList.remove(Turtles[i]);
    		Turtles[i].fd((int) (Math.random()*10));
    		//patches[(int) Turtles[i].xgrid][(int) Turtles[i].ygrid].turtleList.add(Turtles[i]);
    		if (Math.random() > .5) {
    			Turtles[i].rt((int) (Math.random()*30));
    		}
    		else {
    			Turtles[i].lt((int) (Math.random()*30));
    		}
    		
    	}
    	for (int i = 0; i < 100; i++) {
    		//patches[(int) Turtles[i].xgrid][(int) Turtles[i].ygrid].turtleList.remove(Turtles[i]);
    	}
    	//System.out.println("xcoord = "+Turtles[0].xcoord+". prevX = "+Turtles[0].prevX);
    	Thread.sleep(20);
    }
    
    TW.display();

  }

}