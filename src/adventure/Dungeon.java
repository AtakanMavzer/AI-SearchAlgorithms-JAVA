
package adventure;
import java.util.Random;
import java.lang.Math;

public class Dungeon {
	private char [][] dungeon;
	private final int dsize = 20;
	private Point agent;
	private Point goal;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	
	void createDungeon() {
		//Creates a dungeon, with walls around the dungeon, and E is placed randomly with 20% probability
		// P is agent location, and G is the goal location
		dungeon = new char [dsize][dsize];


		Random r = new Random();
		int rndx = r.nextInt(dsize-2) + 1; // generating random number between 1 - dsize-2
		int rndy = r.nextInt(dsize-2) + 1;
		int rndx1=r.nextInt(dsize-2) + 1;
		int rndy1=r.nextInt(dsize-2) + 1;

		if(rndx==rndx1){
			rndx1++;
		}

		agent = new Point(rndx, rndy,0);
		goal = new Point(rndx1,rndy1,0);
		
		
		for(int i=0;i<dsize; i++) {
			for (int j=0;j<dsize; j++) {
				if(i == 0 || j == 0 || i == dsize-1 || j == dsize-1)
					dungeon[i][j] = 'W';
				else
				{
					int rnd = r.nextInt(100);
					if (rnd < 20) //placing E over 20% probability
						dungeon[i][j] = 'E';
					else{
						dungeon[i][j]= '.';
					}
				}
			}
		}
		dungeon[rndx][rndy] = 'P';

		dungeon[rndx1][rndy1] = 'G';

		
	}

	double EuclidianDistance(Point origin){
		Point target=getGoal();
		double ans=Math.sqrt(Math.pow(Math.abs(origin.getX()-target.getX()),2)+Math.pow(Math.abs(origin.getY()-target.getY()),2));
		//System.out.println("yoo"+ans);
		return ans;
	}
	
	void drawDungeon() {
		for (int i=0;i<dsize; i++) {
			for(int j=0;j<dsize; j++) {
				//
				// Enable to see colors for special dungeon marks
				//
				if(dungeon[i][j]=='P')
				System.out.print(ANSI_RED +dungeon[i][j] +ANSI_RESET );
				else if(dungeon[i][j]=='G')
				System.out.print(ANSI_YELLOW +dungeon[i][j] +ANSI_RESET );
				else
				System.out.print(dungeon[i][j]);
			}
			System.out.println();
		}
		System.out.println("____________________________________");
	}	
	
	char get(Point p) {
		return dungeon[p.getX()][p.getY()];
	}
	
	Point getAgent() {
		return agent;
	}
	
	Point getGoal() {
		return goal;
	}
	void markVisited(Point p1) {
		if(dungeon[p1.getX()][p1.getY()] != 'P' && dungeon[p1.getX()][p1.getY()]!='G')
			dungeon[p1.getX()][p1.getY()] = 'V';
	}
	
	boolean shouldVisit(Point p1) {
		if (p1.getX() == 0 || p1.getY() == 0) return false;
		
		
		if (dungeon[p1.getX()][p1.getY()] == 'W' || 
				dungeon[p1.getX()][p1.getY()] == 'E'|| 
				dungeon[p1.getX()][p1.getY()] == 'V' || 
				dungeon[p1.getX()][p1.getY()] == 'P') 
			return false;
		
		return true;
	}
	
	boolean isGoal(Point p1) {
		return dungeon[p1.getX()][p1.getY()] == 'G';
	}
	
	void markX(Point p1) {
		if (dungeon[p1.getX()][p1.getY()]!='P')
		dungeon[p1.getX()][p1.getY()] = 'X';
	}
	void PrintCell(Point p1){
		System.out.println(dungeon[p1.getX()][p1.getY()]);
	}
}

