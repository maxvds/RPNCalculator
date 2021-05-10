package RCPAssignment;
import java.util.*;

public class RPNApp{

public static ArrayStack<Long> stack;
public static void main(String[] args) throws Exception {
	String input = "1 2 3 4 - !";
	stack = new ArrayStack<Long>();
	iterate(input);
	PrintStack(stack);
	
}

/**
 * Takes a String input --> returns a calculated result
 * * pushes each number into a Stack
 * * calls a method on each symbol
 */
public static void PrintStack(Stack<Long> s){ 

    // If stack is empty then return
    if (s.isEmpty())
        return; 
     
    long x = s.peek();
 
    // Pop the top element of the stack
    s.pop();
 
    // Recursively call the function PrintStack
    PrintStack(s);
 
    // Print the stack element starting
    // from the bottom
    System.out.print(x + " ");
 
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
		try{
	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	// take the top of the stack and store is then remove it
	long firstInt = stack.pop();
	 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.pop();

	// do the apprioaite operation 
	result = firstInt + secondInt;
	 
	// push the result 
	stack.push(result); 
	} catch(ArrayIndexOutOfBoundsException e){
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
	result = secondInt - firstInt  ;
	 
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
			System.out.println("division by 0"); 
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
	result = secondInt % firstInt  ;
	 
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
		for(int i = 0;i<quantity;i++){
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


public static void iterate(String input){
	String[] stringArray = input.split(" ");
	int index = 0;
	for(String c : stringArray){
		System.out.println(stringArray[index]);

		if(isNumber(c)){ // if c is a number
			stack.push(Long.parseLong(c));
			index++;
		}
		
		else{ // if c is + - * / % 
			switch (c) {
				case "!" :
				break;
				
				case "+":
					if(("!".equals(stringArray[index+1]))){ // duplicate this code for all different methods
						System.out.println("Exclamation Operator Detected");
						
						for(int n = 0; n < stack.size; n++){
							add();
						}
					}
					add();
					break;
					
				case "-":
					if(("!".equals(stringArray[index+1]))){ // duplicate this code for all different methods
						System.out.println("Exclamation Operator Detected");
						
						for(int n = 0; n < stack.size; n++){
							minus();
						}
					}
					minus();
					break;
					
				case "*":
						if(("!".equals(stringArray[index+1]))){ // duplicate this code for all different methods
							System.out.println("Exclamation Operator Detected");
							
							for(int n = 0; n < stack.size; n++){
								times();
							}
						}
						times();
						break;
						
				case "/":
						if(("!".equals(stringArray[index+1]))){ // duplicate this code for all different methods
							System.out.println("Exclamation Operator Detected");
							
							for(int n = 0; n < stack.size; n++){
								divide();
							}
						}
						divide();
						break;
						
				case "%":
						if(("!".equals(stringArray[index+1]))){ // duplicate this code for all different methods
							System.out.println("Exclamation Operator Detected");
							
							for(int n = 0; n < stack.size; n++){
								mod();
							}
						}
						mod();
						break;
						
				case "c":
						cOperator();
						break; 
				
				case "r": 
					rOperator(); 
					break; 
			}
			index++;
		}
	}
}
}
