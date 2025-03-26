import java.util.*;

public class Leet239MaxSlidingWindow {

    public static void main(String[] args ){
        System.out.println(" ======== ");
        Leet239MaxSlidingWindow main = new Leet239MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = main.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    private class Node{
        int i;
        int num;
        Node(int index, int value){
            this.i = index;
            this.num = value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            while (queue.size() > 0 && (i - queue.getFirst().i >= k)) {
                queue.removeFirst();
            }
            while (queue.size() > 0  && nums[i] > queue.getLast().num) {
                queue.removeLast();
            }
            queue.add(new Node( i, nums[i]));
            if (i >= k - 1)
                result[i - k + 1] = queue.getFirst().num;
        }
        return result;
    }
}

