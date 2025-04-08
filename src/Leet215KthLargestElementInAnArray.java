public class Leet215KthLargestElementInAnArray {

    int[] nums ;


    private void swap(int i, int j){
        int temp = nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = temp;
    }


    private void heapify(int root, int heap_size){
        int largest = root;
        int left = 2*root + 1 ;
        int right = 2*root + 2 ;

        if (left < heap_size && this.nums[left] > this.nums[largest] ){
            largest = left;
        }

        if (right < heap_size && this.nums[right] > this.nums[largest]){
            largest = right;
        }

        if (largest != root){
            int temp = this.nums[root];
            this.nums[root]  = this.nums[largest];
            this.nums[largest] = temp;
            heapify(largest, heap_size);
        }
    }


    private void buildMaxHeap(int heap_size){
        for (int i = heap_size / 2  - 1 ; i >=0 ; i --){
            heapify(i, heap_size);
        }
    }


    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int heap_size = this.nums.length;
        buildMaxHeap(heap_size);
        for (int i = 0; i < k ; i ++){
            if (i == k -1){
                return this.nums[0];
            }else{
                swap(0, heap_size-1);
                heap_size = heap_size -1;
                heapify(0, heap_size);
            }
        }
        return -1;
    }

    public  static  void main(String[] args){
        Leet215KthLargestElementInAnArray x = new Leet215KthLargestElementInAnArray();
        int[] nums = {3,5,7,9,1,2,4};
        int result = x.findKthLargest(nums, 4);
        System.out.println(result);
    }

}
