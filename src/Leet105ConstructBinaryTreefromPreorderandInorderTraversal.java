import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liuxz on 2017/6/24.
 */
public class Leet105ConstructBinaryTreefromPreorderandInorderTraversal {
    List<Integer> temp = new ArrayList<>();

    public static void main(String[] args){
        Leet105ConstructBinaryTreefromPreorderandInorderTraversal xx = new
                Leet105ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] pre = new int[]{1,2,5,3,6};
        int[] in = new int[]{2,5,1,3,6};
        TreeNode root = xx.buildTree(pre, in);
        xx.post(root);
        System.out.println(Arrays.toString(xx.temp.toArray()));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder.length == 0)&&(inorder.length == 0)){
            return null;
        }
        if ((preorder.length == 1)&&(inorder.length== 1)){
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int root_index=0;
        for ( ; root_index < inorder.length; root_index++ ){
            if (preorder[0] == inorder[root_index]) break;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1,1+root_index),
                Arrays.copyOfRange(inorder,0,root_index));

        root.right = buildTree(Arrays.copyOfRange(preorder, root_index+1, preorder.length),
                Arrays.copyOfRange(inorder, root_index+1, inorder.length));
        return root;
    }

    private void post(TreeNode root){
        if(root == null) {return;}
        post(root.left);
        post(root.right);
        temp.add(root.val);
    }
}
