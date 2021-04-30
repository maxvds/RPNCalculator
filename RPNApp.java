package RCPAssignment;
//import java.util.Stack;

public class RNPNApp{

	public static void main(String[] args) {
		String input = "3 4 * 5 2 + -";
		Stack<Integer> stack = new ArrayStack<Integer>();


	
	}

	public void Times(){

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
				throw new OpertionException("too few operands");
			}
		
	}


	public void Addition(){

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
				throw new OpertionException("too few operands");
			}
		
	}

	public void Minus(){

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
				throw new OpertionException("too few operands");
			}
		
	}

	public void Divid(){

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
				throw new OpertionException("too few operands");
			}
		
	}

	public void Mod(){

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
			throw new StackExpection("remainder by 0"); 
		}
		
		
			}else{
				throw new OpertionException("too few operands");
			}
		
	}



    
} 