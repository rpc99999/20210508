package paiza;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B076 {
	
	public static class bread{
		int price;
		int id;
		int stock;
		public bread(int price, int id, int stock) {
			super();
			this.price = price;
			this.id = id;
			this.stock = stock;
		}
		
		public boolean canConsume(int i) {
			if(i>this.stock) {
				return false;
			}
			return true;
		}
		
		public void produce(int i) {
			this.stock += i;
		}
		
		public int consume(int num) {
			this.stock -= num;
			return price*num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitLine = line.split(" ");
        
        int breadType = Integer.parseInt(splitLine[0]);
        int query = Integer.parseInt(splitLine[1]);
        
        Map<Integer, bread> hashMap = new HashMap<Integer, bread>();
        for(int i = 0 ; i < breadType ; i++) {
        	line = sc.nextLine();
        	splitLine = line.split(" ");
        	hashMap.put(i, new bread(Integer.parseInt(splitLine[0]), i , Integer.parseInt(splitLine[1])));
        }
        
        for(int i = 0 ; i < query ; i++) {
        	line = sc.nextLine();
        	splitLine = line.split(" ");
        	if(splitLine[0].equals("buy")) {
        		boolean canConsume = true;
        		for(int j = 0; j < breadType; j++) {
        			bread b = hashMap.get(j);
        			if(!b.canConsume(Integer.parseInt(splitLine[j+1]))) {
        				canConsume = false;
        				break;
        			}
        		}
        		if(canConsume) {
        			int totalPrice = 0;
        			for(int j = 0; j < breadType; j++) {
            			bread b = hashMap.get(j);
            			totalPrice += b.consume(Integer.parseInt(splitLine[j+1]));
        			}
        			System.out.println(totalPrice);
        		}else {
        			System.out.println("-1");
        		}
        	}else if(splitLine[0].equals("bake")) {
        		for(int j = 0; j < breadType; j++) {
        			bread b = hashMap.get(j);
        			b.produce(Integer.parseInt(splitLine[j+1]));
        		}
        	}
        }
        
	}
}
