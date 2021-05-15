package paiza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B091 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int size = Integer.parseInt(line);
        
        boolean[][] checkedCoord = new boolean[size][size];
        int[][] coordHeight = new int[size][size];
        List<Integer> mountainList = new ArrayList<Integer>();
        for(int i = 0; i < size ; i++) {
        	line = sc.nextLine();
        	String[] split = line.split(" ");
        	for(int j = 0 ; j < split.length ; j++) {
        		coordHeight[i][j] = Integer.parseInt(split[j]);
        	}
        }
        for(int i = 0; i < size ; i++) {
        	for(int j = 0; j < size; j++) {
        		if(!checkedCoord[i][j]) {
	        		int height = coordHeight[i][j];
	        		if(i!=0) {
	        			if(height <= coordHeight[i-1][j]) {
		        			checkedCoord[i][j] = true;
		        			continue;	        				
	        			}else {
		        			checkedCoord[i-1][j] = true;	        				
	        			}
	        		}
	        		
	        		if(j!=0) {
	        			if(height <= coordHeight[i][j-1]) {
		        			checkedCoord[i][j] = true;
		        			continue;	        				
	        			}else {
		        			checkedCoord[i][j-1] = true;	        				
	        			}
	        		}
	        		
	        		if(i!=size-1) {
	        			if(height <= coordHeight[i+1][j]) {
		        			checkedCoord[i][j] = true;
		        			continue;	        				
	        			}else {
		        			checkedCoord[i+1][j] = true;	        				
	        			}
	        		}
	        		
	        		if(j!=size-1 && height <= coordHeight[i][j+1]) {
	        			if(height <= coordHeight[i][j+1]) {
		        			checkedCoord[i][j] = true;
		        			continue;	        				
	        			}else {
		        			checkedCoord[i][j+1] = true;	        				
	        			}
	        		}
	        		
	        		// if reach here
	        		// this coord is mountain
	        		checkedCoord[i][j] = true;
	        		mountainList.add(height);
        		}
        	}
        }
        
        Collections.sort(mountainList);
        Collections.reverse(mountainList);
        for(Integer mountain : mountainList) {
        	System.out.println(mountain);
        }
        
        
    }
}
