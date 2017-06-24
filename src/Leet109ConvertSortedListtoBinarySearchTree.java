/**
 * Created by Liuxz on 2017/6/24.
 */


public class Leet109ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args){
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);

        Leet109ConvertSortedListtoBinarySearchTree xx =  new Leet109ConvertSortedListtoBinarySearchTree();
        TreeNode root = xx.sortedListToBST(x);

    }
//    本质上来讲，对于一个二茬平衡树来讲，高度是已经先定好的
//    因此只要根据这个高度，依次访问这些节点就可以了
    private ListNode node = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        node = head;
        int len = 0;
        while(node!=null){
            len++;
            node = node.next;
        }
        node = head;
        return sortedListToBST(0, len-1);
    }
    private TreeNode sortedListToBST(int l, int r){
        if (l > r) return null;
        int m = (l+r)/2;
        TreeNode left = sortedListToBST(l, m-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = sortedListToBST(m+1, r);
        root.left = left;
        root.right = right;
        root.right = right;
        return root;
    }

}
