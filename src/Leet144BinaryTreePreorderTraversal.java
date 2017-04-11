import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxz on 17-4-11.
 */
public class Leet144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Leet144BinaryTreePreorderTraversal xx = new Leet144BinaryTreePreorderTraversal();
        TreeNode a = new TreeNode(1);
        a.right=new TreeNode(2);
        a.right.left=new TreeNode(3);
        a.right.left.left = new TreeNode(7);
        a.right.left.right = new TreeNode(8);
        a.right.right=new TreeNode(5);
        a.right.right.left=new TreeNode(9);
        System.out.println(xx.preorderTraversal(a).toString());
    }
}
