package paiza;

import java.util.Scanner;
import java.util.Vector;

public class B801 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitLine = line.split(" ");
        int width = Integer.parseInt(splitLine[0]);
        int height = Integer.parseInt(splitLine[1]);
        
        Vector<Vector<String>> vector = new Vector<Vector<String>>();
        int numOfRope = 0;
        for(int i = 0; i < height; i++) {
        	line = sc.nextLine();
        	Vector<String> smallVector = new Vector<String>();
        	for(int j = 0 ; j < width; j++) {
        		String tmp = line.substring(j,j+1);
        		smallVector.add(tmp);
        	}
        	vector.add(smallVector);
        }
        
        for(int i = 0; i < height; i++) {
        	for(int j = 0 ; j < width; j++) {
        		if(vector.get(i).get(j).equals("*")) {
        			//check adj. top
        			if(i==0||!vector.get(i-1).get(j).equals("*")) {
        				numOfRope++;
        			}
        			//check adj. bottom
        			if(i==height+1||!vector.get(i+1).get(j).equals("*")) {
        				numOfRope++;
        			}
        			//check left
        			if(j==0||!vector.get(i).get(j-1).equals("*")) {
        				numOfRope++;
        			}
        			//check right
        			if(j==width+1||!vector.get(i).get(j+1).equals("*")) {
        				numOfRope++;
        			}
        		}
        		
        		//counted[i][j] = true;
        	}
        }
        
        System.out.println(numOfRope);
	}
}
