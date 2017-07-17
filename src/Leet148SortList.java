/**
 * Created by Liuxz on 2017/7/11.
 */

public class Leet148SortList {
    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(19);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(-3);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(15);
        Leet148SortList xx = new Leet148SortList();
        head = xx.sortList(head);
        for (ListNode temp = head; temp != null; temp=temp.next){
            System.out.print(temp.val);
            System.out.print("->");
        }
    }

    public ListNode sortList(ListNode head) {
        int l = return_len(head);
        if (l <= 1){return head;}
        int step = l/2;
        ListNode cur = head;
        for (int i = 1 ; i < step ; i ++){
            cur = cur.next;
        }
        ListNode head_b = cur.next;
        cur.next = null;
        return merge(sortList(head), sortList(head_b));
    }


    private int return_len(ListNode node){
        ListNode cur = node;
        int len = 0;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        return len;
    }

    private ListNode merge(ListNode a, ListNode b){
        ListNode a_head = new ListNode(Integer.MIN_VALUE);
        a_head.next = a;
        for(ListNode a_cur = a_head, b_cur = b; b_cur!= null; ){
            if (((a_cur.next != null)&&(a_cur.val<=b_cur.val)&&(b_cur.val<=a_cur.next.val))||
                    ((a_cur.next == null)&&(a_cur.val<=b_cur.val))){
                ListNode temp_b = b_cur;
                b_cur = b_cur.next;
                temp_b.next = a_cur.next;
                a_cur.next = temp_b;
            }else{
                a_cur = a_cur.next;
            }
        }
        return a_head.next;
    }
}
