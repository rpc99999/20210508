package paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A021 {
	//海岸線
	
	public static class Island implements Comparable<Island> {
		int area = 0;
		int perimeter = 0;
		
		public void print() {
			System.out.println(this.area + " " + this.perimeter);
		}
		
	    @Override
		  public int compareTo(Island island) {
		    if(this.area==island.area) {
		    	if(this.perimeter>island.perimeter) {
		    		return 1;
		    	}else if (this.perimeter==island.perimeter) {
		    		return 0;
		    	}else {
		    		return -1;
		    	}
		    }else {
		    	if(this.area > island.area) {
		    		return 1;
		    	}else if(this.area == island.area) {
		    		return 0;
		    	}else {
		    		return -1;
		    	}
		    }
		  }
	}
	
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitStr = line.split(" ");
        
        int height = Integer.parseInt(splitStr[0]);
        int width = Integer.parseInt(splitStr[1]);
        
        String[][] map = new String[height][width];
        for(int i = 0 ; i < height; i++) {
        	line = sc.nextLine();
        	for(int j = 0; j < width; j++) {
        		map[i][j] = line.substring(j, j+1);
        	}
        }
        
        // read all data completed
        
        boolean[][] hasVisited = new boolean[height][width];
        
        List<Island> islandList = new ArrayList<Island>();
        for(int i = 0; i < height; i++) {
        	for(int j = 0 ; j < width ; j++) {
        		if(hasVisited[i][j]) {
        			continue;
        		}else if(map[i][j].equals(".")) {
        			hasVisited[i][j] = true;
        			continue;
        		}else {
        			Island island = new Island();
        			examineIsland(i, j, map, hasVisited, island, height, width);
        			islandList.add(island);
        		}
        	}
        }
        
        Collections.sort(islandList);
        Collections.reverse(islandList);
        
        for(Island i : islandList) {
        	i.print();
        }
        
    }
    
    public static Island examineIsland(int x, int y, String[][] map, boolean[][] hasVisited, Island island, int height, int width) {
    	if(map[x][y].equals("#") && !hasVisited[x][y]) {
    		island.area += 1;
    		island.perimeter += checkPerimeter(x, y, map, height, width);
    		hasVisited[x][y] = true;
    		
    		if(x>0) {
    			island = examineIsland(x-1, y, map, hasVisited, island, height, width);
    		}
    		
    		if(x<height-1) {
    			island = examineIsland(x+1, y, map, hasVisited, island, height, width);
    		}
    		
    		if(y>0) {
    			island = examineIsland(x, y-1, map, hasVisited, island, height, width);
    		}
    		
    		if(y<width-1) {
    			island = examineIsland(x, y+1, map, hasVisited, island, height, width);
    		}
    	}
    	return island;
    }
    
    public static int checkPerimeter(int x, int y , String[][] map, int height, int width) {
    	int value = 0;
    	if(map[x][y].equals("#")) {
    		if(x>0) {
    			if(map[x-1][y].equals(".")) {
    				value++;
    			}
    		}else {
    			value++;
    		}
    		
    		if(x<height-1) {
    			if(map[x+1][y].equals(".")) {
    				value++;
    			}
    		}else {
    			value++;
    		}
    		
    		if(y>0) {
    			if(map[x][y-1].equals(".")) {
    				value++;
    			}
    		}else {
    			value++;
    		}
    		
    		if(y<width-1) {
    			if(map[x][y+1].equals(".")) {
    				value++;
    			}
    		}else {
    			value++;
    		}
    	}
    	return value;
    }
}
