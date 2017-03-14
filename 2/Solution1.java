/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 两个由链表组成的数字，然后加起来。
 * 比如说2/4/3 + 5/6/4 = 7/0/8
 * 过程可以看成是2+5 = 7 , 4+6 =10,3+4+进位的1=8
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//首先判断是否为空
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		//然后首先建立一个答案
		ListNode answer = new ListNode(0);
		ListNode temp = answer; //保存中间变量 
		//考虑进位问题
		int sum = 0;
		//只要有一方没有为空就能继续
		while(l1 != null || l2 != null){
			sum /= 10; //假设上一个传过来的是10一下，则不进位
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			//建立一个新节点
			ListNode sumNode = new ListNode(sum >= 10? sum - 10:sum);
			temp.next = sumNode;
			temp = sumNode;
		}
		//这里有一个陷阱，比如说最后一位发生进位了，9 + 1,如果不做进位处理答案为0
		//但实际答案应该是0->1
		if(sum >= 10){
			ListNode endNode = new ListNode(1);
			temp.next = endNode;
		}
		answer = answer.next; //得到真正的头指针
		return answer;
    }
}