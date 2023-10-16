package RPNCalculator;
import java.util.*;
import RPNCalculator.Stack;
/**
 * ArrayStack class.
 * @author Max, Harry, Tom.
 */
public class ArrayStack<T> implements Stack<T> {
    /** final data field for default stack size. */
    final static int DEFAULT=10;

    /**  data field for generic stack. */ 
    T[]stack;
    
    /**  data field for stack size. */ 
    public int size=0;

    /** Default Constructor for ArrayStack class. */
    public ArrayStack(){
        stack= (T[]) new Object[DEFAULT];
    }
    
    /** Constructor for ArrayStack that creates a stack of a given size. 
     * @param n desired size of stack.
     */
    public ArrayStack(int n){
        stack= (T[]) new Object[n];
    }

    /**
     * Push method.
     * @param element - object to be added to the stack.
     */
    public void push (T element) {
        if (size >= stack.length) {
            enlarge();
        }
        stack[size] = element;
        size++;
    }
    
    /** 
    * Enlarge method - copies the array into a new array double the size.
    */
    public void enlarge(){
        stack=Arrays.copyOf(stack, 2*stack.length);
    }

    /**
     * Peek method.
     * @return the top element in the stack.
     */
    public T peek() {
        if (this.isEmpty()) {
            try {
                throw new Exception("Peek on empty stack");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack[size-1];  
    }
    

    /**
     * Pop method.
     * Removes and returns the top element in the stack.
     * @return the top element in the stack.
     */
    public T pop() {
        if (this.isEmpty()) {
            try {
                throw new Exception("Pop from empty stack");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        size--;
        return stack[size];
    }

    /**
     * isEmpty method.
     * checks if the stack is empty.
     * @return boolean True if the stack is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Size method.
     * @return number of items in the stack.
     */
    public int size() {
        return size;
    }

      
}   
