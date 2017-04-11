import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxz on 17-3-24.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


public class Leet98ValidateBinarySearchTree {
    List<Integer> x = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        int l = x.size();
        for(int i = 0; i < l-1 ; i++) {
            if (x.get(i) >= x.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void traverse(TreeNode node){
        if(node != null){
            traverse(node.left);
            x.add(node.val);
            traverse(node.right);
        }
    }

    public static void main(String[] args){
        Leet98ValidateBinarySearchTree  xx = new Leet98ValidateBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(xx.isValidBST(root));
    }
}
