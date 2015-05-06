

public class Division extends NonTerminalExpression{

	public Division(Expression l, Expression r) {
		super(l, r);

	}

	public double evaluate() {
	    return getLeftNode().evaluate() / getRightNode().evaluate();
	  }

	  

}

