package RCPAssignment;
import java.util.*;
public class RPNApp{

public static ArrayStack<Long> stack;
public static void main(String[] args) throws Exception {

	String input = "3 4 * 5 2 + -";
	stack = new ArrayStack<Long>();
	System.out.println("Input : " +input);
	iterate(input);
	System.out.println(stack.pop());
	

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
	
	if(stack.size() >=2){

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
	
		}else{
			throw new Exception("too few operands");
		}
	
}


public static void add() throws Exception {

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size() >=2){

	// take the top of the stack and store is then remove it
	long firstInt = stack.pop();
	 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.pop();

	// do the apprioaite operation 
	result = firstInt + secondInt;
	 
	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void minus() throws Exception {

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size() >=2){

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
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void divide() throws Exception {

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size() >=2){

	// take the top of the stack and store is then remove it
	long firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	try{
		result = firstInt/ secondInt;
		stack.push(result);
	}catch (ArithmeticException e){
		System.out.println("division by 0"); 
	}
	// push the result 
	
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void mod() throws Exception {

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size() >=2){

	// take the top of the stack and store is then remove it
	long firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	result = firstInt % secondInt;
	 
	// push the result 
	if(result != 0){
		stack.push(result); 
	}else{
		throw new Exception("remainder by 0"); 
	}
	
	
		}else{
			throw new Exception("too few operands");
		}
	
}


public static void iterate(String input) throws Exception{
	int i = 0;
	char[] charArray = (input.replaceAll(" ", "")).toCharArray();
	System.out.println(charArray);
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
