public interface Queueable{
    void addItem(int item);
    int removeItem();
    int peek();
    boolean isEmpty();
    int size();
}