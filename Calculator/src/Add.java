
public class Add extends NonTerminalExpression {
	
	public Add(Expression l, Expression r) {
		super(l, r);
	}
	
	 public double evaluate() {
		    return getLeftNode().evaluate() + getRightNode().evaluate();
		  }

}
