import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Liuxz on 2017/8/21.
 */
public class Leet199BinaryTreeRightSideView {
    List<Integer> result;

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

        Leet199BinaryTreeRightSideView xx = new Leet199BinaryTreeRightSideView();
        List<Integer> output = xx.rightSideView(root);
        for (Integer a : output){
            System.out.println(a);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        result = new LinkedList<>();
        LinkedList<TreeNode> layer= new LinkedList<>();
        if (root == null){
            return result;
        }
        layer.push(root);
        while(layer.size() != 0){
            layer = ergo(layer);
        }
        return result;
    }

    private LinkedList<TreeNode> ergo(LinkedList<TreeNode> layer){
        LinkedList<TreeNode> nextLayer = new LinkedList<>();
        TreeNode temp = null;
        while(layer.size()!=0){
            temp = layer.pollLast();
            if (temp.left != null){
                nextLayer.push(temp.left);
            }
            if (temp.right != null){
                nextLayer.push(temp.right);
            }
        }
        if (temp != null){
            result.add(temp.val);
        }
        layer = null;
        return nextLayer;
    }
}
