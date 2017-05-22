import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

/**
 * Created by Liuxz on 2017/5/22.
 */

public class Leet92ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){return head;}
        ListNode left_a, left_b, right_a, right_b;
        ListNode node1, node2, node3;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        left_a = fakeHead;
        left_b = fakeHead;
        right_a = fakeHead;
        right_b = fakeHead;
        node1 = fakeHead;
        node2 = node1.next;
        node3 = node1.next.next;
        int index = 0;
        while(index <= n){
            if (index == m-1){
                left_a = node1;
                right_a = node1.next;
            }
            if (index == m){
                node2 = node1.next;
                node3 = node1.next.next;
            }
            if (index == n-1){
                left_b = node2;
                right_b= node3;
                node2.next = node1;
                left_a.next = left_b;
                right_a.next = right_b;
            }
            if ((index >= m)&&(index < n-1)){
                node2.next = node1;
                node1 = node2;
                node2 = node3;
                node3 = node3.next;
            }
            if(index < m){
                node1= node1.next;
            }
            index ++;
        }
        return fakeHead.next;
    }

    private void switchNode(ListNode n1, ListNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    public static void main(String[] args){
        Leet92ReverseLinkedList xx = new Leet92ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode newHead = xx.reverseBetween(head, 1, 4);
        for(ListNode cur = newHead; cur != null; cur=cur.next){
            System.out.println(cur.val);
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public String toString(){
          return String.valueOf(this.val);
      }

 }

