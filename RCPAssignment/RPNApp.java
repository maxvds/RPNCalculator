package RCPAssignment;
import java.util.Stack;
import java.util.*;
public class RPNApp{

public static ArrayStack<Long> stack;
public static void main(String[] args) {

	String input = "3 4 * 5 2 + -";
	stack = new ArrayStack<Long>(50);


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
			throw Exception("too few operands");
		}
	
}


public static void add() throws Exception{

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
	result = firstInt + secondInt;
	 
	// push the result 
	stack.push(result); 
	
		}else{
			throw new Exception("too few operands");
		}
	
}

public static void minus() throws Exception{

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

public static void divide() throws Exception{

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

	// take the top of the stack and store is then remove it
	long firstInt = stack.peek(); 
	stack.pop(); 

	// take the top of the stack which was the second and the store it then remove it. 
	long secondInt = stack.peek(); 
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

public static void mod() throws Exception{

	// local var result.
	long result; 
	// take the top of the stack and store is then remove it 

	if(stack.size >=2){

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
	char[] charArray = (input.replaceAll(" ", "")).toCharArray();
	System.out.println(charArray);
	for(char c : charArray){
		if(c > 47 && c < 58){ // if c is a number
			stack.push((long) c);
		}
		else{ // if c is + - * / % 
			switch (c) {
				case '+':
					add();
					break;

				case '-':
					minus();
					break;

				case '*':
					times();
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
