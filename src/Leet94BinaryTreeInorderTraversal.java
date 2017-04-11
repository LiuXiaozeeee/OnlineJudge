import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by liuxz on 17-4-11.
 */



public class Leet94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> cal= new HashSet<>();
        if (root != null){
            stack.add(root);
        }else{
            return result;
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (((temp.left == null)&&(temp.right == null))||cal.contains(temp)){
                result.add(temp.val);
            }else{
                if (temp.right != null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                if (temp.left != null){
                    stack.push(temp.left);
                }
                cal.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Leet94BinaryTreeInorderTraversal xx = new Leet94BinaryTreeInorderTraversal();
        TreeNode a = new TreeNode(1);
        a.right=new TreeNode(2);
        a.right.left=new TreeNode(3);
        a.right.left.left = new TreeNode(7);
        a.right.left.right = new TreeNode(8);
        a.right.right=new TreeNode(5);
        a.right.right.left=new TreeNode(9);
        System.out.println(xx.inorderTraversal(a).toString());
    }
}
