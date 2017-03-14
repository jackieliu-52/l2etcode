/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 一开始没理解题目的意思，所以思路完全错了...
 * 大概思路就是先补全那个比较短的列表然后就可以直接处理了。。
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         List<ListNode> listNodes1 = new ArrayList<>();
        List<ListNode> listNodes2 = new ArrayList<>();
        while (l1 != null) {
            listNodes1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            listNodes2.add(l2);
            l2 = l2.next;
        }
        int length1 = listNodes1.size();
        int length2 = listNodes2.size();
        boolean flag = length1 >= length2;   //看哪个长一点
        int index = flag ? length2 : length1;   //得到比较小的数组长度
        int limit = !flag ? length2 : length1;   //得到比较小的数组长度
        //补全长度短的
        if (flag) {
            for (int i = index; i < length1; i++) {
                listNodes2.add(new ListNode(0));
            }

        } else {
            for (int i = index; i < length2; i++) {
                listNodes1.add(new ListNode(0));
            }

        }
        ListNode answer = new ListNode(-1);   //起点
        ListNode temp = answer; //得到起点的地址
        ListNode temp1 = null;


        index = 0;
        int jinwei = 0;
        while (index < limit) {
            //做加法，这里应该需要考虑进位的问题
            int sum = listNodes1.get(index).val + listNodes2.get(index).val + jinwei;
            jinwei = (sum) / 10;
            if (jinwei == 1) {
                temp1 = new ListNode((sum) % 10); //余数
                temp.next = temp1;             //先确定下一个
                temp = temp1;  //然后再转换
            } else {
                temp1 = new ListNode(sum);
                temp.next = temp1;             //先确定下一个
                temp = temp1;  //然后再转换
            }
            index++;
        }

        //如果到最后还需要进位的话，需要加一个
        if (jinwei == 1) {
            temp1 = new ListNode(1);
            temp.next = temp1;             //先确定下一个
            temp = temp1;
        }

        //长度相同时需要修改
        if (answer.val == -1) {
            answer = answer.next;
        }


        return answer;
    }
}