package Calculator;

public enum Operator {
	PLUS("+", false), 
	MINUS("-", false), 
	MULTIPLY("x", false), 
	DIVIDE("÷", false),
	POW("sqr", true),
	ROOT("√", true),
	PERCENT("%", true);

	
	private String op;
	private boolean instant;
	
	Operator(String op, boolean instant) {
		this.op = op;
		this.instant = instant;
	}
	
	public String getOperator() {
		return op;
	}
	
	public boolean isInstant() {
		return instant;
	}
} 

//package Calculator;
//
//public enum Operator {
//	PLUS("+"), 
//	MINUS("-"), 
//	MULTIPLY("x"), 
//	DIVIDE("÷"),
//	POW("sqr"),
//	ROOT("√"),
//	PERCENT("%");
//
//	
//	private String op;
//	private boolean instant;
//	
//	Operator(String op) {
//		this.op = op;
//		
//	}
//	
//	public String getOperator() {
//		return op;
//	}
//	
//	public boolean isInstant() {
//		return instant;
//	}
//} 
