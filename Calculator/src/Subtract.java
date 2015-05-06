
public class Subtract extends NonTerminalExpression{

	public Subtract(Expression l, Expression r) {
		super(l, r);
		
	}

	public double evaluate() {
	    return getLeftNode().evaluate() - getRightNode().evaluate();
	  }

	  

}
