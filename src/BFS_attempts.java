import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS_attempts {
	public static void main(String[] args) throws FileNotFoundException {
		int [][] maze = new int[5][5];
		Scanner sc = new Scanner(new File("maze"));
		for (int i = 0; i < 5; i++) {
			String ln = sc.nextLine();
			for (int j = 0; j < 5; j++) {
				maze[i][j] = ln.charAt(j)-'0';
			}
		}
		boolean visited [][] = new boolean[5][5];
		int posx= 0; int posy = 0;
		Queue<Integer> xvals = new LinkedList<>();
		Queue <Integer> yvals = new LinkedList<>();
		xvals.add(posx); yvals.add(posy); boolean found = false;
		while(!found && xvals.size()>0){
			posx= xvals.poll(); posy= yvals.poll();
			if(!visited[posx][posy]) {
				visited[posx][posy] = true;
				if (inBounds(posx + 1, posy) && maze[posx + 1][posy] == 0) {
					xvals.add(posx + 1); yvals.add(posy);
				}
				if (inBounds(posx, posy + 1) && maze[posx][posy + 1] == 0) {
					xvals.add(posx); yvals.add(posy+1);
				}
				if (inBounds(posx + 1, posy + 1) && maze[posx + 1][posy + 1] == 0) {
					xvals.add(posx + 1); yvals.add(posy + 1);
				}
			}
			if(posx== 4 && posy ==4){
				found = true;
			}
		}
		System.out.println(found);
	}
	public static boolean inBounds(int x, int y){
		if(x<0 || x>4){
			return false;
		}else return y >= 0 && y <= 4;
	}
}