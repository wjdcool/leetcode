import java.util.Stack;

public class TwoStackAsQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if(stack2.isEmpty()){
            int length = stack1.size();
            for(int i = 0;i<length;i++){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
