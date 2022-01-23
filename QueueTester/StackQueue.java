import java.util.Stack;
public class StackQueue implements Queueable{
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();
    private int size = 0;

    @Override
    public void addItem(int item){
        stackIn.push(item);
        size++;
    }

    @Override
    public int removeItem(){
        if(size < 1){
            throw new IllegalStateException();
        }
        if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.add(stackIn.pop());
            }
        }
        size--;
        return stackOut.pop();
    }

    @Override
    public int peek(){
        if(size < 1){
            throw new IllegalStateException();
        }
        if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();

    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        Stack<Integer> tempStack = new Stack<>();
        while(!stackOut.empty()){
            tempStack.push(stackOut.pop());
        }
        while(!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }
        while(!tempStack.empty()){
            stackOut.push(tempStack.pop());
        }
        return stackOut.toString();
    }
}
