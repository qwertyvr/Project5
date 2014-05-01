import java.util.ArrayList;


public class Patch {
	

	ArrayList<Turtle> turtleList = new ArrayList<Turtle>(100);
	public Patch () {
	}
	
	
	public void addturtle(Turtle t) {
		turtleList.add(t);
	}
	
	
	public void removeturtle(Turtle t) {
		turtleList.remove(t);
	}
}
