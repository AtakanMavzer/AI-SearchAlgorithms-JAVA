
package adventure;


public class Point implements Comparable<Point>{
	private int x, y,cost,totalcost;
	private double distance,totalaction;

	public int compareTo(Point p1) {
		if (x == p1.x && y == p1.y) return 0;
		else return 1;
	}
	// For BFS
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	// For Greedy
	Point(int x, int y,double distance){
		this.x = x;
		this.y = y;
		this.distance=distance;
	}
	// For UniformCost
	Point(int x, int y,int cost,int totalcost){
		this.x = x;
		this.y = y;
		this.cost=cost;
		this.totalcost=totalcost;
	}
	// For A* f=totalcost+heuristic is calculated in constructor
	Point(int x, int y,double distance,int cost,int totalcost){
		this.x = x;
		this.y = y;
		this.distance=distance;
		this.cost=cost;
		this.totalcost=totalcost;
		this.totalaction=totalcost+distance;
	}
	
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTotalaction() {
		return this.totalaction;
	}
	
	public String toString() {
		return "("+ x + "," + y + ")";
	}
}
