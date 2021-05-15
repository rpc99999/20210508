package paiza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class A006 {
	//平面上の移動シミュレーション
	public static class SmallMan {
		int x = 0;
		int y = 0;
		int index = 0;
		boolean stopped = false;
		int dir = 0;
		List<String> tmpList = new ArrayList<String>();
		
		public String move(int t, boolean changeDir) {
			if(this.stopped) {
				return null;
			}
			
			if(t==0) {
				return this.coord();
			}
			
			if(dir==0) {
				x+=1;
			}else if(dir==1) {
				y-=1;
			}else if(dir==2) {
				x-=1;
			}else if(dir==3) {
				y+=1;
			}
			
			if(changeDir) {
				dir = (dir + 1)%4;
			}
			
			System.out.println(this.coord() + this.index);
			return this.coord();
		}
		
		public boolean shouldStop(List<String> coordinateList) {
			boolean shouldStop = false;
			String current = this.coord() + "," + this.index;
			for(String s : coordinateList) {
				if(s.contains(this.coord()) && !s.contains(current)) {
					shouldStop = true;
					break;
				}
			}
			return shouldStop;
		}
		
		public String coord() {
			return "(" + this.x + "," + this.y + ")";
		}
		
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int noOfSmallMan = Integer.parseInt(line);
        
        List<SmallMan> smallManList = new ArrayList<SmallMan>();
        List<String> coordinateList = new ArrayList<String>();
        for(int i = 0 ; i <noOfSmallMan; i++) {
        	line = sc.nextLine();
        	String[] split = line.split(" ");
        	int x_coord = Integer.parseInt(split[0]);
        	int y_coord = Integer.parseInt(split[1]);
        	SmallMan tmp = new SmallMan();
        	tmp.x = x_coord;
        	tmp.y = y_coord;
        	tmp.index = i;
        	smallManList.add(tmp);
        	coordinateList.add(tmp.coord() + "," + i);
        }
        
        int times = 0;
        Stack<Integer> timesToChangeDir = new Stack<Integer>();
        while(true) {
        	//if all item are stop moving, break the loop
        	boolean allStop = true;
        	for(int i = 0 ; i < smallManList.size(); i++) {
        		SmallMan obj = smallManList.get(i);
        		allStop = (allStop && obj.stopped);
        	}
        	
        	if(allStop) {
        		times--;
        		break;
        	}else {
        		times++;
        		// increase the times
        		boolean changeDir = false;
    			List<String> tmpList = new ArrayList<String>();
    			if(timesToChangeDir.isEmpty()) {
    				timesToChangeDir.push(0);
    				timesToChangeDir.push(1);
    			}
    			
    			while(timesToChangeDir.peek()==times) {
        			timesToChangeDir.push(timesToChangeDir.peek() + ((timesToChangeDir.size()+1)/2));
        			changeDir = true;
        		}
    			
        		for(int i = 0 ; i < smallManList.size(); i++) {
        			SmallMan obj = smallManList.get(i);
        			String coord = obj.move(times, changeDir);
        			if(coord!=null) {
        				tmpList.add(coord + "," + i);
        			}
        		}
        		for(int i = 0 ; i < smallManList.size(); i++) {
        			SmallMan obj = smallManList.get(i);
        			if(!obj.stopped) {
        				obj.stopped = obj.shouldStop(coordinateList);
        				obj.stopped = (obj.stopped || obj.shouldStop(tmpList));
        			}
        		}
        		coordinateList.addAll(tmpList);
        	}
        }
        
        System.out.println(times);
       
	}
}
