package RCPAssignment;
//import java.util.Stack;
import java.util.*;
public class RPNApp{

public static void main(String[] args) {

	String input = "3 4 * 5 2 + -";
	//	Stack<Integer> stack = new ArrayStack<Integer>();

	long calculation = iterate(input);

}

/**
 * Takes a String input --> returns a calculated result
 * * pushes each number into a Stack
 * * calls a method on each symbol
 */
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
					Modulo();
					break;
			}
	}
}

<<<<<<< HEAD:RCPAssignment/RPNApp.java


}
    
=======
}
}
>>>>>>> harry:RPNApp.java
