import java.util.Random;

/**
 * Created by Liuxz on 2017/7/20.
 */
public class Leet147InsertSortList {

    public static void main(String[] args){
        Leet147InsertSortList xx = new Leet147InsertSortList();
        ListNode head = new ListNode(0);
        ListNode cur = head;
        Random r = new Random();
        for(int i = 0; i < 10 ; i ++){
            cur.next = new ListNode(Math.abs(1));
            cur = cur.next;
        }
        ListNode return_head = xx.insertionSortList(head);
        for(cur = return_head; cur != null; cur = cur.next){
            System.out.print(cur.val);
            System.out.print(" -> ");
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode fake_head = new ListNode(Integer.MIN_VALUE);
        for (ListNode cur = head; cur != null; cur = cur.next){
            insert(fake_head, cur.val);
        }
        return fake_head.next;
    }

    void insert(ListNode head, int val){
        ListNode t = new ListNode(val);
        for (ListNode cur = head; cur != null ; cur=cur.next){
            if ((cur.val<=val)&&((cur.next == null) ||(val <cur.next.val) )){
                ListNode temp = cur.next;
                ListNode insertNode = new ListNode(val);
                cur.next = insertNode;
                insertNode.next = temp;
                break;
            }
        }
    }
}
