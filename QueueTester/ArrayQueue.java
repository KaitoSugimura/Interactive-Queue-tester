import java.util.Arrays;

public class ArrayQueue implements Queueable {
    private int[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public ArrayQueue(){
        queue = new int[10];
    }

    public ArrayQueue(int arraySize){
        queue = new int[arraySize];
    }

    @Override
    public void addItem(int item){
        if(size >= queue.length){
            throw new IllegalStateException();
        }
        queue[(tail++)%queue.length] = item;
        size++;
    }

    @Override
    public int removeItem(){
        if(size < 1){
            throw new IllegalStateException();
        }
        int value = queue[head%queue.length];
        queue[(head++)%queue.length] = 0; //This is merely for visualization purposes
        size--;
        return value;
    }

    @Override
    public int peek(){
        if(isEmpty()){
            throw new IllegalAccessError();
        }
        return queue[head%5];
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return Arrays.toString(queue);
    }


}
