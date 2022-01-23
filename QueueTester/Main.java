/**
 * @author Kaito Sugimura
 * @version 1.5
 * @since 1.0
 */

 /*
    List of commands:
    addItem(int item);
    removeItem();
    peek();
    isEmpty();
    size();
 */
import java.util.Stack;
import java.util.Scanner;

public class Main {
    //STATIC TESTS
    //Change the size of array in the argument
    static Queueable queue = new ArrayQueue(5); 
    //Uncomment below and comment out above for Stack implementation of queue
    //static Queueable queue = new StackQueue();

    public static void main(String[] args){
        //quickTest();
        //reverse();
        //quickTestWithReverse();

        InteractiveTest(); //Note you will need a typable command line
        //You cannot add 0 as a number in interactive tests
    }

    public static void reverse(){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.removeItem());
        }
        while(!stack.isEmpty()){
            queue.addItem(stack.pop());
        }
    }

    public static void quickTest(){
        queue.addItem(1);
        queue.addItem(2);
        queue.addItem(3);
        System.out.println("After adding 1, 2, then 3: \n" + queue);
        queue.removeItem();
        System.out.println("After removing once: \n" + queue);
        System.out.println("peek: " + queue.peek());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("size: " + queue.size());
    }

    public static void quickTestWithReverse(){
        quickTest();
        reverse();
        System.out.println("After reversing: \n" + queue);
        quickTest();
    }


    public static void InteractiveTest(){
        Scanner input = new Scanner(System.in);
        int selection;
        int add;
        System.out.println("Hello and welcome to the queue tester");
        System.out.println("Note: I will not be checking for the correctness of your inputs");
        System.out.println("Please select a command");
        while(true){
            System.out.println("\n\n0.Exit 1.addItem 2.removeItem 3.peek 4.isEmpty 5.size 6.reverse 9.print");
            System.out.print("selection: ");
            selection = input.nextInt();
            switch (selection){
                case 0:
                    return;
                case 1:
                    System.out.println("Type an number then enter, press 0 to exit loop");
                    while(true){
                        System.out.print("add: ");
                        add = input.nextInt();
                        if(add == 0){
                            break;
                        }
                        queue.addItem(add);
                        System.out.println(queue);
                    }
                    break;
                case 2:
                    System.out.println("Obtained: " + queue.removeItem());
                    System.out.println(queue);
                    break;
                case 3:
                    System.out.println("The next value on Queue is: " + queue.peek());
                    break;
                case 4:
                    System.out.println("Empty state: " + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue size: " + queue.size());
                    break;
                case 6:
                    reverse();
                    System.out.println("\n" + queue);
                    break;
                case 9:
                    System.out.println(queue);
                    break;
                default:
                    return;
            }
        }
    }
}
