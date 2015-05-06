
public class TerminalExpression implements Expression  {

	
    private double value;
	  public TerminalExpression(String v) throws Exception{
	   
		try{
			value = Double.parseDouble(v);
		}
		catch(Exception e){
						
			throw new Exception("Invalid expression"); 			
			
		}
	  }

	@Override
	public double evaluate() {	
		 return value;
	}
	

	  

}
