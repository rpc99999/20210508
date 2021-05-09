package LeetCodeMyself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Problem135 {
	
	
	public static String candy(int[] ratings) {
	//public int candy(int[] ratings) {
    
		if(ratings.length == 0) {
	//		return 0;
		}else if(ratings.length == 1) {
	//		return 1;
		}
		// sort the rating firstly
		int[] candiesBefore = new int[ratings.length];
		int[] candiesAfter = new int[ratings.length];
		Vector<Integer> vector = new Vector<Integer>();
		Map<Integer, ArrayList<Integer>> ratings_indexList = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0 ; i < ratings.length ; i++) {
			if(!vector.contains(ratings[i])) {
				vector.add(ratings[i]);
			}
			
			if(ratings_indexList.get(ratings[i])!=null) {
				ArrayList<Integer> indexList = ratings_indexList.get(ratings[i]);
				indexList.add(i);
				ratings_indexList.put(ratings[i], indexList);
			}else {
				ArrayList<Integer> indexList = new ArrayList<Integer>();
				indexList.add(i);
				ratings_indexList.put(ratings[i], indexList);
			}
		}
		Collections.sort(vector);
		
		// Brute force , not so good performance
		/*
		for(int i = 0 ; i < vector.size(); i++) {
			int targetRating = vector.get(i);
			
			for(int j = 0 ; j < ratings.length ; j++) {
				if(targetRating == ratings[j]) {
					if(j==0) {
						if(candiesBefore[j+1]==0) {
							candiesAfter[j] = 1;
						}else {
							candiesAfter[j] = candiesBefore[j+1] + 1;
						}
					}
					else if(j==ratings.length-1) {
						if(candiesBefore[j-1]==0) {
							candiesAfter[j] = 1;
						}else {
							candiesAfter[j] = candiesBefore[j-1] + 1;
						}
					}else {
						if(candiesBefore[j-1]!=0 && candiesBefore[j+1]!=0) {
							candiesAfter[j] = Math.max(candiesBefore[j-1], candiesBefore[j+1]) + 1;
						}else if(candiesBefore[j-1]!=0) {
							candiesAfter[j] = candiesBefore[j-1] +1;
						}else if(candiesBefore[j+1]!=0) {
							candiesAfter[j] = candiesBefore[j+1] +1;
						}else {
							candiesAfter[j] = 1;
						}
					}
				}
			}
			
			candiesBefore = candiesAfter.clone();
		}*/
		// Brute force , not so good performance
		
		//Faster way but still too long
		//Timeout exceed
		for(int i = 0 ; i < vector.size(); i++) {
			int targetRating = vector.get(i);
			List<Integer> indexList = ratings_indexList.get(targetRating);
			for(int j=0 ; j < indexList.size(); j++) {
				int index = indexList.get(j);
				if(index==0) {
					if(candiesBefore[index+1]==0) {
						candiesAfter[index] = 1;
					}else {
						candiesAfter[index] = candiesBefore[index+1] + 1;
					}
				}
				else if(index==ratings.length-1) {
					if(candiesBefore[index-1]==0) {
						candiesAfter[index] = 1;
					}else {
						candiesAfter[index] = candiesBefore[index-1] + 1;
					}
				}else {
					if(candiesBefore[index-1]!=0 && candiesBefore[index+1]!=0) {
						candiesAfter[index] = Math.max(candiesBefore[index-1], candiesBefore[index+1]) + 1;
					}else if(candiesBefore[index-1]!=0) {
						candiesAfter[index] = candiesBefore[index-1] +1;
					}else if(candiesBefore[index+1]!=0) {
						candiesAfter[index] = candiesBefore[index+1] +1;
					}else {
						candiesAfter[index] = 1;
					}
				}
			}
			candiesBefore = candiesAfter.clone();
		}
		//Faster way but still too long
		
		int result = 0;
		for(int i = 0 ; i < candiesAfter.length ; i++) {
			result += candiesAfter[i];
		}
		return candiesAfter.toString();
		//return result;
    }
	
	public static void main(String[] args) {
		System.out.println(candy(new int[] {1,2,3,4,5}));
	}
}
