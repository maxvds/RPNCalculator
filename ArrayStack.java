package assignment;

public class ArrayStack<T> implements Stack<T> {
    final static int DEFAULT=10;
    T[]stack;
    public int size=0;
    //Default constructor
    public ArrayStack(){
        stack= (T[])new Object[DEFAULT];
    }
    
    public ArrayStack(int n){
        stack=(T[])new Object[n];
    }
    //Push method
    public void push (T element) {
        if (size >= stack.length) enlarge();
        stack[size] = element;
        size++;
      }
    //Enlarge method
    public void enlarge(){
        stack=Arrays.copyOf(stack, 2*stack.length);
    }
    //Peek method
    public T peek() {
        if (this.isEmpty()) {
          throw new StackException("Peek on empty stack");
        }
        return stack[size-1];  
    }
    //Pop method
    public T pop() {
        if (this.isEmpty()) {
          throw new StackException("Pop from empty stack");
        }
        size--;
        return stack[size];
    }
    //Empty checking method
    public boolean isEmpty() {
        return size == 0;
    }
    //Size method
    public int size() {
        return size;
    }
      
}   
