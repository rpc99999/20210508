package paiza;

import java.util.Scanner;

public class A023 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        int interval = Integer.parseInt(line);
        
        line = sc.nextLine();
        String[] isRestDay = line.split(" ");
        
        int result = 0;
        for(int i = 0; i < interval - 7; i++) {
        	int noOfRestDay = 0;
        	for(int j = 0 ; j < 7; j++) {
    			if(isRestDay[(i+j)%isRestDay.length].equals("0")) {
    				noOfRestDay++;
    			}
        	}
        	if(noOfRestDay>1) {
        		result++;
        	}
        }
        
        int tmp = 0;
        for(int i = interval - 7 ; i< interval; i++) {
        	if(isRestDay[i].equals("0")) {
				tmp++;
			}
        }
        if(tmp>1) {
        	result += 7;
        }
        
        System.out.println(result);
		
	}
}
