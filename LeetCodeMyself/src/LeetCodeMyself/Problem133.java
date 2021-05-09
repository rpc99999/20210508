package LeetCodeMyself;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem133 {
	public Node cloneGraph(Node node) {
		Map<Integer, Node> hasBeenVisitedMap = new HashMap<Integer, Node>();
		if(node==null) {
			return node;
		}
		return this.cloneNode(node, hasBeenVisitedMap);
	}
	
	public Node cloneNode(Node node, Map<Integer, Node> hasBeenVisitedMap) {
		Node newNode = new Node();
		newNode.val = node.val;
		newNode.neighbors = new ArrayList<Node>();
		hasBeenVisitedMap.put(newNode.val, newNode);
		if(node.neighbors!=null) {
			for(Node t : node.neighbors) {
				if(hasBeenVisitedMap.get(t.val)!=null) {
					newNode.neighbors.add(cloneNode(t, hasBeenVisitedMap));
				}else {
					newNode.neighbors.add(hasBeenVisitedMap.get(t.val));
				}
			}
		}
		return newNode;
	}
	
}
