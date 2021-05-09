package LeetCodeMyself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem130 {
	public void solve(char[][] board) {
		Queue<String >queue = new LinkedList<String>();
        List<String> coordList = new ArrayList<String>();
        int width = board.length; int height = -1;
        for(int i = 0 ; i < board.length ; i++) {
        	for(int j = 0 ; j < board[i].length ; j++) {
        		if(height == -1) {
        			height = board[i].length;
        		}
        		if(this.isBorder(i, j, height, width) && board[i][j] == 'O') {
        			queue.offer(i+";"+j);
                	coordList.add(i+";"+j);
        		}
        	}
        }

        while(!queue.isEmpty()) {
        	String coord = queue.poll();
        	String[] xy = coord.split(";");
        	int x_coord = Integer.parseInt(xy[0]);
        	int y_coord = Integer.parseInt(xy[1]);
        	if(x_coord+1 <width && !coordList.contains(""+ (x_coord+1)+";"+y_coord) && board[x_coord+1][y_coord] == 'O') {
        		queue.offer(""+ (x_coord+1)+";"+y_coord);
        		coordList.add(""+ (x_coord+1)+";"+y_coord);
        	}
        	
        	if(x_coord-1 >= 0 && !coordList.contains(""+ (x_coord-1)+";"+y_coord) && board[x_coord-1][y_coord] == 'O') {
        		queue.offer(""+ (x_coord-1)+";"+y_coord);
        		coordList.add(""+ (x_coord-1)+";"+y_coord);
        	}
        	
        	if(y_coord+1 <height && !coordList.contains(""+ (x_coord)+";"+(y_coord+1)) && board[x_coord][y_coord+1] == 'O') {
        		queue.offer(""+ (x_coord)+";"+(y_coord+1));
        		coordList.add(""+ (x_coord)+";"+(y_coord+1));
        	}
        	
        	if(y_coord-1 >=0 &&!coordList.contains(""+ (x_coord)+";"+(y_coord-1)) && board[x_coord][y_coord-1] == 'O') {
        		queue.offer(""+ (x_coord)+";"+(y_coord-1));
        		coordList.add(""+ (x_coord)+";"+(y_coord-1));
        	}
        }
        
        for(int i = 0 ; i < board.length ; i++) {
        	for(int j = 0 ; j < board[i].length ; j++) {
        		if(coordList.contains(i+";"+j)) {
        			board[i][j] = 'O';
        		}else {
        			board[i][j] = 'X';
        		}
        	}
        }
    }
	
	public boolean isBorder(int x, int y, int height, int width) {
		return (x==0||x==width-1||y==0||y==height-1);
	}
}
