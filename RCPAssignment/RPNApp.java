package RCPAssignment;
//import java.util.Stack;
import java.io.*; 
import java.util.*;
public class RPNApp{




public static void main(String[] args) {



	String input = "3 4 * 5 2 + -";
	Stack<Integer> stack = new ArrayStack<Integer>();

	long calculation = iterate(input);
	 
}

/**
 * Takes a String input --> returns a calculated result
 * * pushes each number into a Stack
 * * calls a method on each symbol
 */

public static void Times(){

	// local var result.
	int result; 
	// take the top of the stack and store is then remove it 
	
	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	int firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	int secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	result = firstInt * secondInt;

	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}


public static void Add(){

	// local var result.
	int result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	int firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	int secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	result = firstInt + secondInt;
	 
	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void Minus(){

	// local var result.
	int result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	int firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	int secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	result = firstInt - secondInt;
	 
	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void Divide(){

	// local var result.
	int result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	int firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	int secondInt = stack.peek(); 
	stack.pop(); 

	// do the apprioaite operation 
	try{
		result = firstInt/ secondInt;
	}catch (ArithmeticException e){
		System.out.println("division by 0"); 
	}
	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void Mod(){

	// local var result.
	int result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	int firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	int secondInt = stack.peek(); 
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


public static long iterate(String input){
	char[] charArray = (input.replaceAll(" ", "")).toCharArray();
	System.out.println(charArray);
	for(char c : charArray){
		if(c > 47 && c < 58){ // if c is a number
			stack.push(c);
		}
		else{ // if c is + - * / % 
			switch (c) {
				case '+':
					Add();
					break;

				case '-':
					Minus();
					break;

				case '*':
					Times();
					break;

				case '/':
					Divide();
					break;

				case '%':
					Mod();
					break;
			}
	}
}



}
    
}
