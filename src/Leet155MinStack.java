import java.util.Stack;

public class Leet155MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_stack = new Stack<>();

    public Leet155MinStack() {
        this.stack = new Stack<>();
        this.min_stack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if (this.min_stack.empty() ||(this.min_stack.peek() >= val)){
            this.min_stack.add(val);
        }
    }

    public void pop() {
        int val = this.stack.pop();
        if (this.min_stack.peek() == val){
            this.min_stack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.min_stack.peek();
    }

    public static  void main(String[] args){
        Leet155MinStack x = new Leet155MinStack();
        x.push(0);
        x.push(1);
        x.push(0);
        System.out.println(x.getMin());
        x.pop();
        System.out.println(x.getMin());
        x.pop();
        System.out.println(x.getMin());
    }

}
