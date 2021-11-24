
package adventure;
import java.util.*;

public class Greedy {
	Dungeon dung;
	Dungeon dungo;
	Queue<Point> v1 = new PriorityQueue<Point>(new Comparator<Point>() {
		public int compare(Point p1, Point p2) {
			{
                if (p1.getDistance() > p2.getDistance())
                    return 1;
                else if (p1.getDistance() < p2.getDistance())
                    return -1;
				else
                    return 0;
			}
		}
	  });

	Map<Point, Point> parents;
	
	int pathLength;
	
	public Greedy() {
		dung = new Dungeon();
		dung.createDungeon();
		
		parents = new HashMap<>();
		parents.put(dung.getAgent(), null);
		v1.add(dung.getAgent());
		
		pathLength = 0;
		
		System.out.println("************************************");		
		System.out.println("Before the Greedy Search");
		System.out.println("************************************");
		dung.drawDungeon();
	}
	
	void applyGreedy(){
		while(!v1.isEmpty()) {
		Point p1 = v1.remove();

		if(dung.isGoal(p1)) {
			this.traverseParents(p1);
			break;
		}
		dung.markVisited(p1);
		this.traverseAdjacentCells(p1);
		}
		System.out.println("************************************");		
		System.out.println("After the Greedy Search, total path lenght: " + pathLength);
		System.out.println("************************************");
		dung.drawDungeon();
	}
	void traverseAdjacentCells(Point s){
		for (int i=-1;i<2;i++) {
			for (int j=-1; j<2 ;j++) {
				Point p0 = new Point(s.getX() + i, s.getY() + j);
				Point p1 = new Point(s.getX() + i, s.getY() + j,dung.EuclidianDistance(p0));
				if(dung.shouldVisit(p1)) {
				parents.put(p1, s);
				v1.add(p1);

				}	
			}
		}
	}
	
	void traverseParents(Point p1) {
		if (p1==null) {
			return;
		}
		if(parents.get(p1)!=null){
			dung.markX(parents.get(p1));
		}
		pathLength++;
		traverseParents(parents.get(p1));	
	}

	
}

