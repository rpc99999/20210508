package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     
    	int sumOfDiff = 0;
    	
    	for(int i = 0 ; i < gas.length ; i++) {
    		sumOfDiff += (gas[i]- cost[i]);
    	}

    	// if sum of gas <¡@sum of cost
    	// then return -1
    	if(sumOfDiff<0) {
    		return -1;
    	}
    	
    	int pointer = 0;
    	Integer gasRemain[][] = new Integer[gas.length][gas.length];		// gasRemain[0][0] ---> remaining gas from 0th station to 1st station
    	
    	while(pointer < gas.length) {
    		int remain = 0;
	    	for(int i  = 0 ; i < gas.length ; i++) {
	    		remain += (gas[(pointer + i) % gas.length] - cost [(pointer+i)% gas.length]);
    			gasRemain[pointer][i] = remain;
	    		if(remain < 0) {
	    			break;
	    		}
	    	}
	    	if(remain<0) {
		    	pointer++;
	    	}else {
	    		return (pointer);
	    	}
    	}
    	

    	return -1;
    }
}
