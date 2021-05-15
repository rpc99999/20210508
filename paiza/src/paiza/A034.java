package paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class A034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        String[] splitStr = line.split(" ");
        
        int candyTypeNum = Integer.parseInt(splitStr[0]);
        int money = Integer.parseInt(splitStr[1]);
        
        int[] candyPrice = new int[candyTypeNum];
        
        for(int i = 0 ; i < candyTypeNum; i++) {
        	line = sc.nextLine();
        	candyPrice[i] = Integer.parseInt(line);
        }
        
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        for(int i = 0 ; i< candyTypeNum; i++) {
        	if(candyPrice[i] <= money) {
        		List<Integer> tmpList = new ArrayList<Integer>();
        		tmpList.add(i);
        		queue.add(tmpList);
        	}
        }
        
        if(queue.size()==0) {
        	// no solution
        	System.out.println(money);
        }else {
        	int maxType = 0;
        	HashMap<Integer, Integer> maxType_MaxValue = new HashMap<Integer, Integer>();
        	while(!queue.isEmpty()) {
        		List<Integer> tmpList = queue.poll();
        		int sum = 0;
        		int type = tmpList.size();
        		for(int i = 0 ; i < tmpList.size() ;i++) {
        			sum += candyPrice[tmpList.get(i)];
        		}
        		
        		if(maxType_MaxValue.get(type)!=null) {
        			maxType_MaxValue.put(type, Math.max(maxType_MaxValue.get(type), sum));
        		}else {
        			maxType_MaxValue.put(type, sum);
        			maxType = type;
        		}
        		
        		for(int i = 0 ; i < candyTypeNum; i++) {
        			if(!tmpList.contains(i) && sum+candyPrice[i]<=money) {
        				List<Integer> tmpList2 = new ArrayList<Integer>(tmpList);
        				tmpList2.add(i);
        				queue.add(tmpList2);
        			}
        		}
        		
        	}
        	
        	System.out.println(money - maxType_MaxValue.get(maxType));
        }
        
        
	}
	
	
}
