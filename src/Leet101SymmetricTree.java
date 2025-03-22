import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Liuxz on 2017/6/14.
 */
public class Leet101SymmetricTree {
    List<Integer> PreOrder;
    List<Integer> PostOrder;
    public boolean isSymmetric(TreeNode root) {
        this.PreOrder = new LinkedList<>();
        this.PostOrder= new LinkedList<>();
        left(root);
        right(root);
        return Objects.equals(PreOrder, PostOrder);
    }

    private void left(TreeNode root){
        if (root == null){PreOrder.add(-1);return;}
        left(root.left);
        left(root.right);
        PreOrder.add(root.val);
    }

    private void right(TreeNode root){
        if (root == null){PostOrder.add(-1);return;}
        right(root.right);
        right(root.left);
        PostOrder.add(root.val);
    }


    public static void main(String[] args){
        Leet101SymmetricTree xx = new Leet101SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(3);
        System.out.println(xx.isSymmetric(root));
    }
}
