
public class Multiply extends NonTerminalExpression {

	public Multiply(Expression l, Expression r) {
	    super(l, r);
	  }
	
	public double evaluate() {
	    return getLeftNode().evaluate() * getRightNode().evaluate();
	  }
	
}
