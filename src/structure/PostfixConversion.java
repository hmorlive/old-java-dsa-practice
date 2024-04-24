package structure;

/**
 * InfixToPostfix() class
 * @author hazmed
 * @version 1.0
 */
public class PostfixConversion {
	MyStack opStack; //stack object
	boolean loFlag, nullFlag; //flags for lower operator/null
	String postfix = ""; //output string
	static String nums, operators, hiOp, loOp, letters; //operators and numbers or letters
	
	//Constructor
	public PostfixConversion() {
		opStack = new MyStack();
		loFlag = false;
		nullFlag = false;
		nums = "0123456789";
		letters = "abcdefghijklmnopqrstuvwxyz";
		operators = "+-*/%";
		hiOp = "*/%";
		loOp = "+-";
	}
	
	//Runs the program
	public void run(){
		String infix = "a * (1 + 2 - 3) / 2";
		infix = infix.replaceAll("\\s", "");
		System.out.println("Infix:   " + infix);
		System.out.println("Postfix: " + convert(infix));
	}
	
	/**
	 * Converts into postfix
	 * @param data - infix to be converted
	 * @return postfix - postifx expression
	 */
	private String convert(String data) {
		char check, peepStack = 'a';
		try {
			conversionLoop:
			for (int i = 0; i < data.length(); i++) {
				check = data.charAt(i);
				
				if (nums.indexOf(check) >= 0 || letters.indexOf(check) >= 0) {
					postfix += check;
					
					while (!(opStack.isEmpty())) {
						peepStack = (char) opStack.top();
						if (peepStack == '(') continue conversionLoop; // continues if open parenthesis
						if (loOp.indexOf(peepStack) >= 0) continue conversionLoop; //continues if lower operator in stack
						postfix += opStack.pop();
					}
					continue conversionLoop;
				}
				operation(check); // checks operations
				parenthesis(check); //checks for parenthesis
			}
			while (!opStack.isEmpty()) postfix += opStack.pop(); //inserts anything left in stack
		}
		catch (NullPointerException e) {
			nullFlag = true;
			return "Invalid";
		}
		return postfix;
	}
	
	/**
	 * Checks operators and adds to stack
	 * @param check - takes in char to be checked
	 */
	private void operation(char check) {
		char peepStack = 'a';
		//ads higher operator to stack	
		if (hiOp.indexOf(check) >= 0) {
			opStack.push(check);
			return;
		}
		//ads lower operator to stack
		if (loOp.indexOf(check) >= 0 && (loFlag == false)) {
			loFlag = true;
			opStack.push(check);
			return;
		}
		//inserts lower operator in stack when another low operator is found
		if (loOp.indexOf(check) >= 0 && (loFlag == true)) {
			peepStack = (char) opStack.top();
			if (peepStack != '('){
				postfix += opStack.pop();
				opStack.push(check);
			}
			return;
		}
	}
	
	/**
	 * Checks for open and closed parenthesis
	 * @param check - character to be checked
	 */
	private void parenthesis(char check) {
		char peepStack = 'a';
		//checks for open parenthesis
		if (check == '(') {
			opStack.push(check);
			loFlag = false;
			return;
		}
		//checking for closing parenthesis;
		if (check == ')') {
			peepStack = (char) opStack.top();
			//popping everything until open parenthesis
			while (!(peepStack == '(')) {
				if (loOp.indexOf(peepStack) >= 0) loFlag = false;
				postfix += opStack.pop();
				peepStack = (char) opStack.top();
			}
			opStack.pop();
			
			//checks for operator before parenthesis
			if (!opStack.isEmpty()) {
				peepStack = (char) opStack.top();
				//setting loOpFlag to true if lower priority operator
				if (loOp.indexOf(peepStack) >= 0) loFlag = true;
				//popping if higher priority operator
				if (hiOp.indexOf(peepStack) >= 0) {
					postfix += opStack.pop();
					if (!opStack.isEmpty()) peepStack = (char) opStack.top();
					if (loOp.indexOf(peepStack) >= 0) loFlag = true;
				}
			}
		}
	}
}
