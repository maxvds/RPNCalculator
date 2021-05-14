package week10;


/**
 * Stack interface for Assignment.
 * @author - Max, Harry, Tom
 * @param <T> 
 * 
 */
public interface Stack <T> {

    /** Push method that stack must implement. 
     * @param element object to be added to stack.
    */
    public void push (T element);

    /** Pop method that stack must implement. 
     * @return top item of stack. */
    public T pop();
    
    /** Peek method that stack must implement.
    * @return top item of stack. */
    public T peek();

    /** isEmpty method that stack must implement. 
     * @return True boolean if stack is empty. */
    public boolean isEmpty();

    /** size method that stack must implement. 
     * @return int size of stack. */
    public int size();

}
