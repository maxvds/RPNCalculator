package RCPAssignment;
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
 *  runs run() which prompts the user for an input. 
 * @param args 
 * @throws Exception if 
 */
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		run(scan);
	}

	/**
	 * propts the user for a string then call iterate method on the string. 
	 * @throws Exception
	 */
	public static void run(Scanner scan) throws Exception{
		while(scan.hasNextLine()){
			stack = new ArrayStack<Long>();
			String s; 
			s = scan.nextLine();
			iterate(s);
			if(stack.isEmpty() != true){
				System.out.print("["); 
				printStack(stack);
				System.out.print("]"); 
			}

	}
	


}

	public static void printStack(Stack<Long> s){ 
		// If stack is empty then return
		if (s.isEmpty())
			return; 
		

		long x = s.peek();

	
		// Pop the top element of the stack
		s.pop();
		
		// Recursively call the function PrintStack
		printStack(s);
	
		// Print the stack element starting
		// from the bottom
		if(s.size() == 0){
			System.out.print(x);
		}else{
			System.out.print(", " + x );
		}
		
	
		// Push the same element onto the stack
		// to preserve the order
		s.push(x);
		
	}

	public static void times(){

		// local var result.
		long result; 
		// take the top of the stack and store is then remove it 
		
		try{

		// take the top of the stack and store is then remove it
		long firstInt = stack.peek(); 
		stack.pop(); 

		// take the top of the stack which was the second and the store it then remove it. 
		long secondInt = stack.peek(); 
		stack.pop(); 

		// do the apprioaite operation 
		result = firstInt * secondInt;

		// push the result 
		stack.push(result); 
		
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Error: too few operands"); 
			}
		
	}


	public static void add(){
		long result; 

		try{
		// local var result.
		
		// take the top of the stack and store is then remove it 

		// take the top of the stack and store is then remove it
		long firstInt = stack.peek();
		stack.pop();
		

		// take the top of the stack which was the second and the store it then remove it. 
		long secondInt = stack.peek();
		stack.pop();

		// do the apprioaite operation 
		result = firstInt + secondInt;
		
		// push the result 
		stack.push(result); 
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: too few operands"); 
		} catch(Exception p){
			System.out.println("Error: too few operands");
		}
		
	}

	public static void minus(){

		// local var result.
		long result; 
		// take the top of the stack and store is then remove it 

		try{

	// take the top of the stack and store is then remove it
	long firstInt = stack.peek();
	stack.pop(); 
	 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.peek();
	stack.pop(); 

		// do the apprioaite operation 
		result = secondInt - firstInt;
		
		// push the result 
		stack.push(result); 
		
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Error: too few operands"); 
			}
		
	}

	public static void divide(){

		// local var result.
		long result; 
		// take the top of the stack and store is then remove it 

		try{

			// take the top of the stack and store is then remove it
			long firstInt = stack.peek(); 
			stack.pop(); 

			// take the top of the stack which was the second and the store it then remove it. 
			long secondInt = stack.peek(); 
			stack.pop(); 

			// do the apprioaite operation 
			try{
				result = secondInt / firstInt;
				// push the result
				stack.push(result);
			}catch (ArithmeticException e){
				System.out.println("Error: division by 0"); 
			}
		// push the result 
		
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: too few operands"); 
		}
		
	}

	public static void mod(){

		// local var result.
		long result; 
		// take the top of the stack and store is then remove it 

		try{

		// take the top of the stack and store is then remove it
		long firstInt = stack.peek(); 
		stack.pop(); 

		// take the top of the stack which was the second and the store it then remove it. 
		long secondInt = stack.peek(); 
		stack.pop(); 

		// do the apprioaite operation 
		result = secondInt % firstInt;
		
		// push the result 
		stack.push(result); 

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: too few operands"); 
		}catch(ArithmeticException e){
			System.out.println("Error: Mod by zero"); 
		}


	}

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

	public static void rOperator(){ 

		try{

			// quantiy which are moving curr back 
			long flipX = stack.peek(); 
			stack.pop();

			// temp array for all the numbers which are being moved infront of curr
			long[] temp = new long[(int)(flipX-1)]; 

			// removing curr to be placed down the stack by filpX amount. 
			

			long curr = stack.peek(); 
			stack.pop(); 
			
			// first placing the top of the stack at the back of the array and progressive moving down the stack

			for(int i = 0;i < temp.length;i++){
				temp[i] = stack.peek(); 
				stack.pop();  
			}

			// adding curr onto the correct postion in the stack. 
		
			stack.push(curr); 
			
			// adding the rest of the nums back onto the stack. 
			for(int i = 0;i<temp.length;i++){
				stack.push(temp[(temp.length-1)-i]); 
			}



		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: too few operands"); 
		}
	}
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
	 * 
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
	 * parathese takes a s between () then mulitples it by the top of the stack the is put iterate method. 
	 * @param s
	 * @throws Exception
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
 * Takes a String input --> returns a calculated result
 * * pushes each number into a Stack
 * * calls a method on each symbol
 * 
 */
  public static void iterate(String input) throws Exception{
	String[] stringArray = input.split(" ");
	for( int i = 0; i < stringArray.length; i++ ){
		if(isNumber(stringArray[i])){ // if c is a number
			stack.push(Long.parseLong(stringArray[i]));
		}
		
		else{ // if c is + - * / % 
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
				case ")":
					break;

				case "(": 
					boolean con = true; 
					String s = ""; 
				
					do{
						switch (stringArray[i+2]){
							case ")": 
								con = false; 
								break; 

							case "(": 
								System.out.println("Error: Unmatched parentheses");
		
						}
						s += (stringArray[i+1] + " "); 
						i++; 
					}while(con); 
					parenthese(s);
					break;	
				default:
					System.out.println("Error: bad token " + "'" + stringArray[i] +"'");

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