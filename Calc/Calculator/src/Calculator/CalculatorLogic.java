package Calculator;

public interface CalculatorLogic {

	void inputNumber(Digit digit);
//	void actionPerformed(String a);

	void inputOperator(Operator operator);
	
	void deleteDigit();

	void inputSign();
	void inputComma(Comma comma);
	
	/**
	 * Gibt die aktuelle Operation zurüclk
	 * 
	 * @return doe altielle Operation
	 */
//	Operator getLastOperator();

	double getResult();
	
	double getEqual();

	String getPath();

	void addResultListener(ResultListener listener);
	
	double delAll();

//	void inputComma();

}
