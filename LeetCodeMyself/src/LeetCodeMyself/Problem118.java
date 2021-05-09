package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	int[][] matrix = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
        	List<Integer> tmpList = new ArrayList<Integer>();
        	if(i==0) {
        		matrix[0][0] = 1;
        		tmpList.add(1);
        		resultList.add(tmpList);
        	}else if(i==1) {
        		matrix[1][0] = 1;
        		matrix[1][1] = 1;
        		tmpList.add(1);
        		tmpList.add(1);
        		resultList.add(tmpList);
        	}else {
        		for(int j = 0; j < i+1; j++) {
        			if(j==0||j==i) {
        				matrix[i][j] = 1;
        				tmpList.add(1);
        			}else {
        				matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
        				tmpList.add(matrix[i][j]);
        			}
        		}
        		resultList.add(tmpList);
        	}
        }
        return resultList;
    }
}
