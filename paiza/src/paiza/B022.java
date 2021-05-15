package paiza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B022 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int candidateNo = Integer.parseInt(split[0]);
        int voterNo = Integer.parseInt(split[1]);
        int noOfTurn = Integer.parseInt(split[2]);
        
        // array to store no. of vote for each voter
        int[] candiate_noOfVote = new int [candidateNo];
        int noOFVoterSupportNone = voterNo;
        
        for(int i = 0 ; i < noOfTurn; i++) {
        	line = sc.nextLine();
        	int tmp = Integer.parseInt(line);
        	for(int j = 0 ; j < candidateNo; j++) {
        		if(j!=(tmp-1)) {
        			if(candiate_noOfVote[j]>0) {
        				candiate_noOfVote[j]--;
        				candiate_noOfVote[tmp-1]++;
        			}
        		}else {
        			if(noOFVoterSupportNone>0) {
        				noOFVoterSupportNone--;
        				candiate_noOfVote[tmp-1]++;
        			}
        		}
        	}
        }
        
        int maxVote = 0;
        List<Integer> candidateList = new ArrayList<Integer>();
        for(int i = 0 ; i < candidateNo; i++) {
        	if(candiate_noOfVote[i]>maxVote) {
        		candidateList.clear();
        		candidateList.add(i);
        		maxVote = candiate_noOfVote[i];
        	}else if(candiate_noOfVote[i]==maxVote){
        		candidateList.add(i);
        	}
        }
        
        for(Integer result : candidateList) {
        	System.out.println(result+1);
        }
        
	}
}
