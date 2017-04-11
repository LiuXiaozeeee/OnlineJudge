import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by liuxz on 17-4-11.
 */
public class Leet103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode mark = new TreeNode(-1);
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        boolean flip = true;
        queue.offer(root);
        queue.offer(mark);
        List<Integer> res = new ArrayList<>();
        while(true){
            TreeNode temp = queue.poll();
            if (temp == mark){
                result.add(res);
                res = new ArrayList<>();
                if (queue.isEmpty()){break;}
                queue.offer(mark);
            }else{
                res.add(temp.val);
                if (temp.right != null){
                    queue.add(temp.right);
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
            }
        }
        for (int i = 0; i <result.size(); i ++){
            if (i % 2 == 0){
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args){
        Leet103BinaryTreeZigzagLevelOrderTraversal xx = new Leet103BinaryTreeZigzagLevelOrderTraversal();
        TreeNode a = new TreeNode(1);
        a.right=new TreeNode(2);
        a.right.left=new TreeNode(3);
        a.right.left.left = new TreeNode(7);
        a.right.left.right = new TreeNode(8);
//        a.right.right=new TreeNode(5);
//        a.right.right.left=new TreeNode(9);
        System.out.println(xx.zigzagLevelOrder(a).toString());
    }

}
