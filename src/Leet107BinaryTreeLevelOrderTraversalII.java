import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liuxz on 2017/6/24.
 */
public class Leet107BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args){
        Leet107BinaryTreeLevelOrderTraversalII xx = new Leet107BinaryTreeLevelOrderTraversalII();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        List<List<Integer>> result = xx.levelOrderBottom(root);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<Integer> one_layer = new ArrayList<>();
        LinkedList<TreeNode> contain = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        do {
            while (!temp.isEmpty()){
                TreeNode a = temp.poll();
                one_layer.add(a.val);
                if(a.left!=null){contain.offer(a.left);}
                if(a.right!=null){contain.offer(a.right);}
            }
            result.push(new ArrayList<>(one_layer));
            one_layer.clear();
            temp = new LinkedList<>(contain);
            contain.clear();
        }while(!temp.isEmpty());
        return result;
    }
}
