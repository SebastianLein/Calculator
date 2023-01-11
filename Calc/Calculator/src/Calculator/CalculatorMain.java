package Calculator;

public class CalculatorMain {

	public static void main(String[] args) {
		var calc = new CalculatorLogicImpl();

//		calc.inputNumber(1);
//		calc.inputNumber(2);
//		calc.plus(0, 0);
//		calc.inputNumber(8);
//		calc.equals(0);
//		
//		double r = calc.getResult();
//		if(r != 20) {
//			System.err.println("Fehler");
//		}

		CalcGui gui = new CalcGui(calc);
		gui.init();
		
		System.out.println(calc.getResult()+calc.getPath());
		
//		System.out.println(calc.inputOperator(Digit.FOUR.getValue(), Digit.FIVE.getValue(), Operator.PLUS));

//		String str = "Hallo ich bin seit heute 18";
//		System.out.println(str.replaceAll("[^0-9]", ""));

	}

}
