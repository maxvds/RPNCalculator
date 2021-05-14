package week10;
import java.util.*;

/**
 * Application class which runs the RPN calculator. 
 * @author max, harry and tom. 
 * 
 */
public class RPNApp{

    /**
     * Data field for the current stack. 
     */
    public static ArrayStack<Long> stack;

    /**
     *  Main Method.
     * Creates a Scanner object and Executes the run method on it.
     * @param args 
     * @throws Exception Multiple Exceptions - covered in methods.
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        run(scan);
    }

    /**
     * Run method.
     * creates a local stack object, prompts the user for a string, 
     * then calls the iterate() method onto the string.
     * @param scan - a scanner object that is used to take input.
     * @throws Exception Multiple Exceptions - covered in methods.
     */
    public static void run(Scanner scan) throws Exception{
        while(scan.hasNextLine()){
            stack = new ArrayStack<Long>();
            iterate(scan.nextLine());

            if(!stack.isEmpty()){
                System.out.print("["); 
                printStack(stack);
                System.out.print("]"); 
                System.out.println();
            }
        }
    }

/**
* Prints each stack item in the correct order.
* @param s the array stack created and filled in by the run and iterate methods.
*/
    public static void printStack(Stack<Long> s){ 
        if (s.isEmpty()){
            return; 
        }
        
        long x = s.peek();
        s.pop();

        printStack(s);
    
        if(s.size() == 0){
            System.out.print(x);
        }else{
            System.out.print(", " + x );
        }

    // Push the same element onto the stack
    // to preserve the order and size counter
        s.push(x);
        
    }

    /**
    * Times method that takes the top two stack items,
    * multiplies them and pushes the result.
    */
    public static void times(){

        long result; 
        
        try{
            long firstInt = stack.peek(); 
            stack.pop(); 

            long secondInt = stack.peek(); 
            stack.pop(); 

            result = firstInt * secondInt;

            stack.push(result); 
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        }
    }

    /**
     * Adding method that takes the top two stack items,
     * adds them and pushes the result.
     */
    public static void add(){

        long result; 

        try{
            long firstInt = stack.peek();
            stack.pop();
            
            long secondInt = stack.peek();
            stack.pop();

            result = firstInt + secondInt;
            
            stack.push(result);

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        } catch(Exception p){
            System.out.println("Error: too few operands");
        }
    }

    /**
     * Subtraction method that takes the top two stack items,
     * subtracts them and pushes the result.
     */
    public static void minus(){

        long result; 

        try{
            long firstInt = stack.peek();
            stack.pop(); 
            
            long secondInt = stack.peek();
            stack.pop(); 

            result = secondInt - firstInt;
            
            stack.push(result); 
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        }
    }

    /**
     * Division method that takes the top two stack items,
     * divides them and pushes the result.
     */
    public static void divide(){

        long result; 

        try{

            long firstInt = stack.peek(); 
            stack.pop(); 

            long secondInt = stack.peek(); 
            stack.pop(); 

            try{
                result = secondInt / firstInt;
                stack.push(result);

            }catch (ArithmeticException e){
                System.out.println("Error: division by 0"); 
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        }
    }

    /**
     * Modular method that takes the top two stack items,
     * divides them and pushes the result the result.
     */
    public static void mod(){
        long result; 

        try{
            long firstInt = stack.peek(); 
            stack.pop(); 

            long secondInt = stack.peek(); 
            stack.pop(); 

            result = secondInt % firstInt;
        
            stack.push(result); 
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        
        }catch(ArithmeticException e){
            System.out.println("Error: Mod by zero"); 
        }
    }

    /**
     * fetches the top of the stack and second item on the stack and 
     * added the second item to the top of the stack by the top amount. 
     */
    public static void cOperator(){

        try{ 
            // take the top element use it to expand the 2 element 
            long quantity  = stack.peek(); 
            stack.pop(); 
            // second element 
            long amount = stack.peek(); 
            stack.pop(); 
            // pushes second element by quantity amount of times. 
            for(int i = 0 ; i < quantity ; i++ ){
                stack.push(amount); 

            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        }
            
    }

    /**
     * Using the number on the top of the stack,
     * to move the second item down the stack that amout of times. 
     */
    public static void rOperator(){ 

        try{

            long flipX = stack.peek(); 
            stack.pop();

            long[] temp = new long[(int)(flipX-1)]; 

            long curr = stack.peek(); 
            stack.pop(); 
            
            for(int i = 0;i < temp.length;i++){
                temp[i] = stack.peek(); 
                stack.pop();  
            }
            
            stack.push(curr); 
            
            for(int i = 0;i<temp.length;i++){
                stack.push(temp[(temp.length-1)-i]); 
            }
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        }
    }
    
    /**
     * duplicates the top of the stack. 
     */
    public static void dOperator(){

        
        try{
            // take the top of the stack 
            long topOfStack = stack.peek(); 
            // push it to the top
            stack.push(topOfStack); 

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        } 
        
    }
    /**
     * print the top of the stack. 
     */
    public static void oOperator(){ 

        
        try{
            // print the top of the stack. 
            System.out.print(stack.peek() + " ");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: too few operands"); 
        } 
        
    }

    /**
     * Parenthese method.
     * Takes the top of the stack, and determines how many 
     * times the string within the brackets is going to execute on the stack.
     * @param s - the whitespace separated token in between 2 brackets.
     * @throws Exception Multiple Exceptions - covered in methods.
     */
    public static void parenthese(String s)throws Exception{

        String addedString = "";
        long topStack = stack.peek(); 
        stack.pop(); 

        for(int i = 0; i < topStack ; i++ ){
            addedString += s; 
        }

        iterate(addedString); 
    }


/**
 * Iterate method.
 * Takes an input and returns a calculated result in Stack form.
 * @param input - a white space separated token with numbers and operators.
 * @throws Exception for Bad Token.
 */
    public static void iterate(String input) throws Exception{
        String[] stringArray = input.split(" ");
        for( int i = 0; i < stringArray.length; i++ ){
            if(isNumber(stringArray[i])){ // if c is a number
                stack.push(Long.parseLong(stringArray[i]));
            } else{ // if c is + - * / % 
                switch (stringArray[i]) {
                    case "+!" :
                    {
                        int stackSize = stack.size-1;

                        for(int n = 0; n < stackSize; n++){
                            add();
                        }
                    }
                        break;
                
                    case "-!" :
                    {
                        int stackSize = stack.size-1;

                        for(int n = 0; n < stackSize; n++){
                            minus();
                        }
                    }        
                        break;
                        
                    case "*!" :
                    {
                        int stackSize = stack.size-1;

                        for(int n = 0; n < stackSize; n++){
                            times();
                        }
                    }
                        
                        break;

                    case "/!" :
                    {
                        int stackSize = stack.size-1;

                        for(int n = 0; n < stackSize; n++){
                            divide();
                        }   
                    }
                        
                        break;

                    case "%!" :
                    {
                        int stackSize = stack.size-1;

                        for(int n = 0; n < stackSize; n++){
                            mod();
                        }
                    }

                        break;
                    
                    case "+":
                        add();
                        break;

                    case "-":
                        minus();
                        break;

                    case "*":
                        times();
                        break;

                    case "/":
                        divide();
                        break;

                    case "%":
                        mod();
                        break;

                    case "c":
                        cOperator();
                        break; 
                    
                    case "r": 
                        rOperator(); 
                        break; 

                    case "d": 
                        dOperator(); 
                        break; 
                    
                    case "o": 
                        oOperator(); 
                        break; 
                    
                    case "(":  
                        String s = "";  

                        // Filtering through the token within the parentheses.
                        while(true){
                            if(stringArray[i+1].equals(")")){
                                break; 
                            }else if(stringArray[i+1].equals("(")){ 
                                int count = Integer.parseInt(
                                    String.valueOf(s.charAt(s.length()-2)));
                                
                                s = s.substring(0, s.length() - 2); 
                                String temp = ""; 
                                
                                while(true){
                                    if(stringArray[i+1].equals(")")){
                                        break; 
                                    }
                                    
                                    temp += (stringArray[i+2] + " "); 
                                    i++; 
                                }
                                
                                temp = temp.substring(0, temp.length() - 2);
                                
                                for(int j = 0;j < count; j++){
                                    s += temp; 
                                }
                                i++; 
                            }
                            s +=(stringArray[i+1] + " "); 
                            i++; 
                        }
                        parenthese(s);
                        break;
                    case ")":
                        break; 
                    default:
                        System.out.println("Error: bad token "
                            + "'" + stringArray[i] + "'");
                        stack = new ArrayStack<Long>();
                }
            }   
        }   
    }

    /**
     * Method for checking if tokens are numbers.
     * @param str token from input
     * @return boolean if its a number or not
     */
    public static boolean isNumber(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        
        } catch(NumberFormatException e){  
            return false;  
        }  
    }


}
