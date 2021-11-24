
package adventure;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {


		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Search with: \n1 : BFS \n2 : UCS\n3 : Greedy\n4 : A*  ");
	
		int selection = myObj.nextInt();  

		if(selection==1){
			BFS mazebfs = new BFS();
			mazebfs.applyBFS();
		}
		else if(selection==2){
			UniformCost mazeuniform = new UniformCost();
			mazeuniform.applyUniformCost();
			
		}
		else if(selection==3){
			Greedy mazegreed = new Greedy();
			mazegreed.applyGreedy();
			
		}
		else if(selection==4) {
			// Costs for each action is defined as cost=2
			AstarEuclidian mazeastar= new AstarEuclidian();
			mazeastar.applyAstarEuclidian();
		}
		myObj.close();
	}
}

