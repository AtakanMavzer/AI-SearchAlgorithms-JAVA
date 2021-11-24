
package adventure;
import java.util.*;

public class BFS {
	Dungeon dung;
	Dungeon dungo;
	Queue<Point> v1 = new LinkedList<>();
	Map<Point, Point> parents;
	
	int pathLength;
	
	public BFS() {
		dung = new Dungeon();
		dung.createDungeon();
		
		parents = new HashMap<>();
		parents.put(dung.getAgent(), null);
		v1.add(dung.getAgent());
		
		pathLength = 0;
		
		System.out.println("************************************");		
		System.out.println("Before the BFS Search");
		System.out.println("************************************");
		dung.drawDungeon();
	}
	
	void applyBFS(){
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
		System.out.println("After the BFS Search, total path lenght: " + pathLength);
		System.out.println("************************************");
		dung.drawDungeon();
	}
	void traverseAdjacentCells(Point s){
		for (int i=-1;i<2;i++) {
			for (int j=-1; j<2 ;j++) {
				Point p1 = new Point(s.getX() + i, s.getY() + j);
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

