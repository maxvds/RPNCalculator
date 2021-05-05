package RCPAssignment;
import java.util.*;

public class RPNApp{

public static ArrayStack<Long> stack;
public static void main(String[] args) throws Exception {

	String input = "0 2 %";
	stack = new ArrayStack<Long>();
	System.out.println("Input : " +input);
	iterate(input);
	System.out.println(stack.peek()); 
	stack = new ArrayStack<Long>();
}

/**
 * Takes a String input --> returns a calculated result
 * * pushes each number into a Stack
 * * calls a method on each symbol
 */

public static void times() throws Exception{

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


public static void add() throws Exception {


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

public static void minus() throws Exception {

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
	result = firstInt - secondInt;
	 
	// push the result 
	stack.push(result); 
	
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: too few operands"); 
		}
	
}

public static void divide() throws Exception {

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
			result = firstInt/ secondInt;
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

public static void mod() throws Exception {

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
	result = firstInt % secondInt;
	 
	// push the result 
	stack.push(result); 

	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Error: too few operands"); 
	}catch(ArithmeticException e){
		System.out.println("Error: Mod by zero"); 
	}
	
	
		
	
}


public static void iterate(String input) throws Exception{
	int i = 0;
	char[] charArray = (input.replaceAll(" ", "")).toCharArray();
	for(char c : charArray){
		if(c > '/' && c < ':'){ // if c is a number
			i = c - '0';
			stack.push((long)i);
		}
		else{ // if c is + - * / % 
			switch (c) {
				case '+':
					add();
					System.out.println("add");
					break;

				case '-':
					minus();
					break;

				case '*':
					times();
					System.out.println("times");
					break;

				case '/':
					divide();
					break;

				case '%':
					mod();
					break;
				}
			}
		}
	}
}
