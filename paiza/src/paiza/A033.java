package paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class A033 {
	//読書の課題
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        
        int noOfBook = Integer.parseInt(split[0]);
        int targetDays = Integer.parseInt(split[1]);
        
        int[] pagePerBK = new int[noOfBook];
        int[] dayPerBK = new int[noOfBook];
        
        int[][] optimalSol = new int[targetDays+1][noOfBook+1];
        for(int  i = 0 ; i < noOfBook ; i++) {
        	line = sc.nextLine();
        	split = line.split(" ");
        	pagePerBK[i] = Integer.parseInt(split[0]);
        	dayPerBK[i] = Integer.parseInt(split[1]);
        }
        
       for(int i = 0 ; i <= targetDays; i++) {
    	   for(int j = 0; j <= noOfBook; j++) {
    		   if(i==0||j==0) {
    			   optimalSol[i][j] = 0;
    		   }
    		   
    		   if(dayPerBK[j-1] > i) {
    			   optimalSol[i][j] = optimalSol[i][j-1];
    		   }else {
    			   optimalSol[i][j] = Math.max(optimalSol[i][j-1], optimalSol[i-dayPerBK[j-1]][j-1] + pagePerBK[j-1]);
    		   }
    		   
    	   }
       }
       
       System.out.println(optimalSol[targetDays][noOfBook]);
        
	}
	
}
