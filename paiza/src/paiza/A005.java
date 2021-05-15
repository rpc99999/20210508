package paiza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A005 {
	
	public static class Frame{
		int score1 = 0;
		boolean score1Filled = false;
		int score2 = 0;
		boolean score2Filled = false;
		int score3 = 0;
		boolean score3Filled = false;
		int bottles = 0;
		int nthFrame = 0;
		Frame nextFrame = null;
		
		public Frame(int nthFrame, int bottles) {
			this.nthFrame = nthFrame;
			this.bottles = bottles;
		}
		
		public boolean isStrike() {
			return bottles == score1;
		}
		
		public boolean isSpare() {
			return bottles == (score1+score2);
		}
		
		public int totalScore() {
			int bonus = 0;
			if(this.isStrike()) {
				if(nextFrame!=null) {
					if(nextFrame.isStrike()) {
						if(nextFrame.nextFrame!=null) {
							bonus = nextFrame.nextFrame.score1 + nextFrame.score1;
						}else {
							bonus = nextFrame.score1 + nextFrame.score2;
						}
					}else {
						bonus = nextFrame.score1 + nextFrame.score2;
					}
				}else {
					if(this.score2==bottles) {
						bonus = this.score2 + this.score3 + this.score3;
					}else {
						bonus = this.score2 + this.score3;
					}
				}
			}else if(this.isSpare()) {
				if(nextFrame!=null) {
					bonus = nextFrame.score1;
				}else {
					bonus = this.score3;
				}
			}
			
			return this.score1 + this.score2 + this.score3 + bonus;
		}
		
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int frames = Integer.parseInt(split[0]);
        int bottles = Integer.parseInt(split[1]);
        int noOfTurns = Integer.parseInt(split[2]);
        
        Frame fr = new Frame(1, bottles);
        List<Frame> frameList = new ArrayList<Frame>();
        for(int i = 0; i < noOfTurns; i++) {
        	String str = sc.next();
        	int score = 0;
        	if(!str.equals("G")) {
        		score = Integer.parseInt(str);
        	}
        	
        	if(!fr.score1Filled) {
        		fr.score1 = score;
        		fr.score1Filled = true;
        	}else if(!fr.score2Filled) {
        		fr.score2 = score;
        		fr.score2Filled = true;
        	}else if(!fr.score3Filled && fr.nthFrame == frames && (fr.isSpare() || fr.isStrike())) {
        		fr.score3 = score;
        		fr.score3Filled = true;
        	}
        	
        	if(fr.nthFrame!= frames) {
	        	if(fr.isStrike()) {
	        		fr.nextFrame = new Frame(fr.nthFrame+1, bottles);
	        		frameList.add(fr);
	        		fr = fr.nextFrame;
	        	}else if(fr.isSpare()) {
	        		fr.nextFrame = new Frame(fr.nthFrame+1, bottles);
	        		frameList.add(fr);
	        		fr = fr.nextFrame;
	        	}else {
	        		if(fr.score1Filled && fr.score2Filled) {
	        			fr.nextFrame = new Frame(fr.nthFrame+1, bottles);
	        			frameList.add(fr);
	        			fr = fr.nextFrame;
	        		}
	        	}
        	}else {
        		if(i==noOfTurns-1) {
        			frameList.add(fr);
        		}
        	}
        }
        
        int totalScore = 0;
        for(Frame frame : frameList) {
        	System.out.println(frame.totalScore());
        	totalScore += frame.totalScore();
        }
        System.out.println(totalScore);
    }
}
