package paiza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class A035 {
	//試験の作成
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String line = sc.nextLine();
	     
	     int noOfQuestion = Integer.parseInt(line);
	     int[] score = new int[noOfQuestion];
	     Queue<Integer> questionQueue = new LinkedList<Integer>();
	     for(int i  = 0 ; i < noOfQuestion ; i++) {
	    	 line = sc.nextLine();
	    	 score[i] = Integer.parseInt(line);
	    	 questionQueue.add(i);
	     }
	     
	     Set<Integer> resultList = recursive(score, questionQueue);
	     System.out.println(resultList.size());
	     for(Integer i : resultList) {
	    	 System.out.println(i);
	     }
	 }
	 
	 public static Set<Integer> recursive(int[] score, Queue<Integer> questionQueue){
		 if(questionQueue.isEmpty()) {
			 Set<Integer> result =  new TreeSet<Integer>();
			 result.add(0);
			 return result;
		 }else {
			 Integer questionNo = questionQueue.poll();
			 Set<Integer> scoreList =  recursive(score, questionQueue);
			 Set<Integer> cloneList = new TreeSet<Integer>(scoreList);
			 Iterator<Integer> iterator=cloneList.iterator();    
			  
			 while(iterator.hasNext()) {  
				 scoreList.add(iterator.next() + score[questionNo]);
			 }
			 return scoreList;
		 }
	 }
}
