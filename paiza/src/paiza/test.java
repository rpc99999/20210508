package paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test {
	
	public static List<String> dirList = Arrays.asList("F","R","B","L");
	
	public static class robot{
		int x, y;
		int up, down, left, right;
		String currentDir = "F";
		
		public robot(int x, int y, int up, int right, int down, int left) {
			super();
			this.x = x;
			this.y = y;
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
		}
		
		public void changeCurrentDir(String dir) {
			int index = dirList.indexOf(dir);
			if(index!=-1) {
				int currentIndex = dirList.indexOf(this.currentDir);
				int newIndex = (index+currentIndex)%4;
				this.currentDir = dirList.get(newIndex);
			}
		}

		public void moveUp() {
			if(currentDir.equals("F")) {
				this.y+=up;
			}else if(currentDir.equals("R")) {
				this.x+=up;
			}else if(currentDir.equals("B")) {
				this.y-=up;
			}else if(currentDir.equals("L")) {
				this.x-=up;
			}
		}
		
		public void moveDown() {
			if(currentDir.equals("F")) {
				this.y-=down;
			}else if(currentDir.equals("R")) {
				this.x-=down;
			}else if(currentDir.equals("B")) {
				this.y+=down;
			}else if(currentDir.equals("L")) {
				this.x+=down;
			}
		}
		
		public void moveLeft() {
			if(currentDir.equals("F")) {
				this.x-=left;
			}else if(currentDir.equals("R")) {
				this.y+=left;
			}else if(currentDir.equals("B")) {
				this.x+=left;
			}else if(currentDir.equals("L")) {
				this.y-=left;
			}
		}
		
		public void moveRight() {
			if(currentDir.equals("F")) {
				this.x+=right;
			}else if(currentDir.equals("R")) {
				this.y-=right;
			}else if(currentDir.equals("B")) {
				this.x-=right;
			}else if(currentDir.equals("L")) {
				this.y+=right;
			}
		}
		
		public void reportCoord() {
			System.out.println(this.x + " " + this.y + " " + this.currentDir);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String line2 = sc.nextLine();
        String[] input = line.split(" ");
        String[] input2 = line2.split(" ");
        
        robot b = new robot(Integer.parseInt(input[0]),
        		Integer.parseInt(input[1]),
        		Integer.parseInt(input2[0]),
        		Integer.parseInt(input2[1]),
        		Integer.parseInt(input2[2]),
        		Integer.parseInt(input2[3])
        		);
        
         line = sc.nextLine();
        int count = Integer.parseInt(line);
        for(int i = 0 ; i < count ; i++) {
        	line = sc.nextLine();
        	input = line.split(" ");
        	if(input[0].equals("t")) {
        		b.changeCurrentDir(input[1]);
        	}else if (input[0].equals("m")) {
        		if(input[1].equals("F")) {
        			b.moveUp();
        		}else if(input[1].equals("R")) {
        			b.moveRight();
        		}else if(input[1].equals("B")) {
        			b.moveDown();
        		}else if(input[1].equals("L")) {
        			b.moveLeft();
        		}
        	}
        	 b.reportCoord();
        }
        
        b.reportCoord();
        
	}
	
}
