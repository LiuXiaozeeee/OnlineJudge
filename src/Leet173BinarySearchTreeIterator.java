import sun.reflect.generics.tree.Tree;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by liuxz on 17-4-13.
 */
public class Leet173BinarySearchTreeIterator {
    private TreeNode current;
    private Stack<TreeNode> stack;

//    public void BSTIterator(TreeNode root) {
//        current = root;
//        stack = new Stack<TreeNode>();
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty() || current!=null;
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        while (!stack.isEmpty() || current!=null) {
//            if (current!=null) {
//                stack.push(current);
//                current = current.left;
//            } else {
//                current = stack.peek().right;
//                break;
//            }
//        }
//        TreeNode node = stack.pop();
//        return node.val;
//    }
//
//    public static void main(String[] args){
//        Leet173BinarySearchTreeIterator xx = new Leet173BinarySearchTreeIterator();
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(6);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        xx.BSTIterator(root);
//        while(xx.hasNext()){
//            System.out.println(xx.next());
//        }
//    }
}
