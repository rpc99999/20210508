package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
	public List<Integer> getRow(int rowIndex) {
		int[] numArray = new int[rowIndex+1];
		int[] prevArray = new int[rowIndex+1];
		for(int i = 0; i <= rowIndex; i++) {
			for(int j = 0; j <= i ; j++) {
				if(j==0 || j == i) {
					numArray[j]=1;
				}else {
					numArray[j]=prevArray[j] + prevArray[j-1];
				}
			}
			for(int j = 0; j <= i ; j++) {
				prevArray[j]=numArray[j];
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i < numArray.length; i++) {
			result.add(numArray[i]);
		}
		return result;
	}
}
