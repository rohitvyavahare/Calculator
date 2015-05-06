import java.util.*;

public class Calculator {

	private String expression;

	private HashMap<String, String> operators;

	public Calculator() {

		/*
		 * HashMap is create to keep precedence in operators. 
		 * Higher precedence have grater value.
		 * 
		 */
		
		
		operators = new HashMap<String, String>();
		operators.put("+", "1");
		operators.put("-", "1");
		operators.put("/", "2");
		operators.put("*", "2");		
	}

	public void setExpression(String expr) {
		expression = expr;
	}

	public double evaluate() {
		// Convert expression to Prefix
		String postfix = toPostFix(expression);

		// convert to Binary Tree and get root of it.
		Expression root = createTree(postfix);

		// Evaluate the tree
		return root.evaluate();
	}

	private NonTerminalExpression getNonTerminalExpression(String operation,Expression l, Expression r) {

		if (operation.trim().equals("+")) {
			return new Add(l, r);
		}

		if (operation.trim().equals("-")) {
			return new Subtract(l, r);
		}
		if (operation.trim().equals("*")) {
			return new Multiply(l, r);
		}
		
		if (operation.trim().equals("/")) {
			return new Division(l, r);
		}

		return null;
	}

	private Expression createTree(String expr) {

		Stack<Expression> s = new Stack<Expression>();

		String[] exprs = expr.split(" ");

		for (int i = 0; i < exprs.length; i++) {
			String currChar = exprs[i];

			if (isOperator(currChar) == false) {
				try{
					Expression e = new TerminalExpression(currChar);
					s.push(e);
				}
				catch(Exception e){
					System.out.println(e.toString());
				}
				
				
			} else {
				Expression r = s.pop();
				Expression l = s.pop();
				Expression n = getNonTerminalExpression(currChar, l, r);
				s.push(n);
			}
		}// for

		return s.pop();
	}

	private String toPostFix(String input) {

		Stack<String> stack = new Stack<String>();
		StringBuilder postfix = new StringBuilder();
		String tempStr = "";

		input = input.trim();
		for (int i = 0; i < input.length(); i++) {

			while (i < input.length() && !(isOperator(input.substring(i, i + 1)))) {

				postfix.append(input.substring(i, i + 1));
				i++;
			}

			postfix.append(" ");

			// if the current character is an operator 
			if (i < input.length() && isOperator("" + input.charAt(i))) {

				if (stack.isEmpty() == false) {

					tempStr = stack.pop();
					String strVal1 = operators.get(tempStr);
					int val1 = new Integer(strVal1).intValue();
					String strVal2 = operators.get("" + input.charAt(i));
					int val2 = new Integer(strVal2).intValue();

					while ((val1 >= val2)) {

						postfix.append(tempStr);
						postfix.append(" ");
						val1 = Integer.MIN_VALUE;

						if (stack.isEmpty() == false) {

							tempStr =  stack.pop();
							strVal1 =  operators.get(tempStr);
							val1 = new Integer(strVal1).intValue();

						}

					}
					if ((val1 < val2) && (val1 != Integer.MIN_VALUE))
						stack.push(tempStr);
				}
				stack.push("" + input.charAt(i));
			}// if

		}// for
		while (stack.isEmpty() == false) {

			tempStr = stack.pop();
			postfix.append(tempStr);
			postfix.append(" ");

		}
		return postfix.toString();
	}

	private boolean isOperator(String str) {
		if ((str.equals("+")) || (str.equals("-")) || (str.equals("*"))
				|| (str.equals("/")))
			return true;
		return false;
	}
}
