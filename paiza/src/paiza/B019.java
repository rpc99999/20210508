package paiza;

import java.util.Scanner;

public class B019 {

	public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int originalSize = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        
        int[][] originalPic = new int[originalSize][originalSize];
        int[][] newPic = new int[originalSize/k][originalSize/k];
        
        for(int i = 0 ; i <originalSize; i++) {
        	line = sc.nextLine();
        	split = line.split(" ");
        	for(int j = 0 ; j < originalSize; j++) {
        		originalPic[i][j] = Integer.parseInt(split[j]);
        		newPic[i/k][j/k] += originalPic[i][j];
        	}
        }
        
        for(int i = 0 ; i < originalSize/k; i++) {
        	for(int j = 0 ; j < originalSize/k; j++) {
        		newPic[i][j] = (newPic[i][j]/k)/k;
        		System.out.print(newPic[i][j]);
        		if(i==originalSize/k - 1) {
                	System.out.println();
            	}else {
            		System.out.print(" ");
            	}
        	}
        }
        
        
    }
	
}
