/**
 * Created by Liuxz on 2017/6/14.
 */
public class Leet100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }

    private boolean helper(TreeNode p, TreeNode q){
        if ((p == null) &&(q == null)){
            return true;
        }else if ((p == null)||(q == null)){
            return false;
        }else if (p.val == q.val){
            return helper(p.left, q.left) && helper(p.right, q.right);
        }else{
            return false;
        }
    }
}
