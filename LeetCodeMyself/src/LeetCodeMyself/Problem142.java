package LeetCodeMyself;

public class Problem142 {
	 public ListNode detectCycle(ListNode head) {
		 if(head==null || head.next==null) {
			 return null;
		 }
		 ListNode fastPointer = head.next.next;
		 ListNode slowPointer = head.next;
		 while(fastPointer!=null && fastPointer!=slowPointer) {
			  if(fastPointer.next==null) {
				  return null;
			  }else {
				  fastPointer = fastPointer.next.next;
				  slowPointer = slowPointer.next;
			  }
		 }
		 
		 if(fastPointer==null) {
			 return null;
		 }else {
			 fastPointer = head;
			 while(fastPointer!=slowPointer) {
				 fastPointer = fastPointer.next;
				 slowPointer = slowPointer.next;
			 }
			 return fastPointer;
		 }
	 }
}
