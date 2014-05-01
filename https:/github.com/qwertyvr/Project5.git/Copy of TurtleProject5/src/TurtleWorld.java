import java.awt.*;

import javax.swing.*;

/** 
 * TurtleWorld provides a high level drawing context for a Turtle
 */
public class TurtleWorld {

  /**
   * Instance Variables
   */
  JFrame frame;
  TurtlePanel tPanel;

  /**
   * Constructor for a TurtleWorld "context".
   */
  public TurtleWorld(){
    /**
     * A swing JFrame and TurtlePanel (JPanel) 
     * are created and initially painted
     */
    frame = new JFrame();
    tPanel = new TurtlePanel();
    frame.getContentPane().add (tPanel);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**
   * Draw a line on the TurtleWorld "context".
   */
  public void  doDrawLine(double x1, double y1, double x2, double y2){
    tPanel.doDrawLine(x1,y1,x2,y2);
  }
  
  static int[][] grid = new int[51][51];
  
  public void startgrid() {
	  for (int i = 0; i < 51; i++) {
		  for (int j = 0; j < 51; j++) {
			  grid[i][j] = 0;
		  }
	  }
	  System.out.println();
  }

  /**
   * Prints out the 51x51 grid of 0's and 1's.
   */
  public static void display() {
	for (int i = 0; i < 51; i++) {
		for (int j = 0; j < 51; j++) {
			System.out.print(grid[i][j]);
		}
		System.out.println("");
	}
  }
  
  /**
   * Converts the 400x400 screen with drawings to a 51x51 grid of 0's and 1's.
   * The method goes to every coordinate on the grid between
   * the two end-points.
   */
  public static void bumps(double x1, double y1, double x2, double y2, Turtle t) {
	  
	  int x1grid;
	  int x2grid;
	  int y1grid;
	  int y2grid;
	  x1grid = (int) (x1*(51/400.0));
	  x2grid = (int) (x2*(51/400.0));
	  y1grid = (int) (y1*(51/400.0));
	  y2grid = (int) (y2*(51/400.0));
	  
	  
	  
	  
	  /*
	  if (x1grid == x2grid) {
		  for (int i = y1grid; i <= y2grid; i++) {
			  if (i >=51 || i < 0) {
				  continue;
			  }
			  else {
				  grid[i][x1grid] = 1;
			  }
			  //System.out.println("changing x = "+x1grid+", y = "+i);
		  }
		  for (int i = y2grid; i <= y1grid; i++) {
			  if (i >=51 || i < 0) {
				  continue;
			  }
			  else {
				  grid[i][x1grid] = 1;
			  }
		  }
	  }
	  
	  else if (x1grid < x2grid) {
		  for (int i = x1grid; i <= x2grid; i++) {
			  if (i >=51 || i < 0) {
				  continue;
			  }
			  else {
				  int y = (int) (((y1 - y2)/(x1 - x2))*i + y1grid - ((y1 - y2)/(x1 - x2)) * x1grid);
				  if (y < 0) {
					  y = y + 51;
				  }
				  if (y >= 51) {
					  y = y - 51;
				  }
				  grid[y][i] = 1;
			  }
		  } //y=mx+b
		  
	  }
	  else {
		  for (int i = x2grid; i <= x1grid; i++) {
			  if (i >=51 || i < 0) {
				  continue;
			  }
			  else {
				  int y = (int) (((y1 - y2)/(x1 - x2))*i + y1grid - ((y1 - y2)/(x1 - x2)) * x1grid);
				  if (y < 0) {
					  y = y + 51;
				  }
				  if (y >= 51) {
					  y = y - 51;
				  }
				  grid[y][i] = 1;
			  }
		  }
	  }*/
	  
		  
  }
    
}