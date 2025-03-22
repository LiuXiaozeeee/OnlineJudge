

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by liuxz on 17-4-13.
 */
public class Leet173BinarySearchTreeIterator {
    private LinkedList<TreeNode> stack;

    public Leet173BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        for (TreeNode temp = root; temp != null; temp = temp.left){
            stack.push(temp);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop();
        for (TreeNode temp = result.right; temp!= null ; temp = temp.left){
            stack.push(temp);
        }
        return result.val;
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right= new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
//        xx.BSTIterator(root);
        Leet173BinarySearchTreeIterator xx = new Leet173BinarySearchTreeIterator(root);
        while(xx.hasNext()){
            System.out.println(xx.next());
        }
    }
}
