package Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.lang.Math;
import java.math.MathContext;
import java.text.DecimalFormat;

public class CalculatorLogicImpl implements CalculatorLogic {
//private static final int MAX_INPUT = 1000000;
	// Fehler bei Eingabe von vieler Zahlen, wenn Zahl größer
	private int value;

	private int digits = 0;
	private double number = 0;
	private double number2 = 0;
	private String a;
	private boolean numberReady = false;
	private boolean lastInputWasOperation = false;
	private Operator storedOperator;

	private boolean commaSet = false;
	private int commaCounter = 0;

	private List<ResultListener> resultListeners = new LinkedList<>();

	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public void inputNumber(Digit digit) {

		if (!lastInputWasOperation) {
			digits = digits * 10 + digit.getValue();

//			String doubleAsString = String.valueOf(number);
//			int indexOfDecimal = doubleAsString.indexOf(".");
//			if (!commaSet) {
//				for (int i = 0; i < Double.toString(indexOfDecimal).length() - 2; i++) {
//					System.out.println(number / (Math.pow(10, i)));
////					System.out.println(Double.toString(number).length()-2);
//					System.out.println(Double.toString(number).substring(indexOfDecimal));
////					a = df.format(number);
//					System.out.println(a);
//
//				}
//			}

		} else {

			digits = digit.getValue();
			numberReady = true;
		}
		if (commaSet) {
			commaCounter++;
		}
		number = (double) digits / Math.pow(10, commaCounter);
		lastInputWasOperation = false;

		fireResultChanged();
		debug();
	}

	@Override
	public void deleteDigit() {
		String str1 = String.valueOf(digits);
		str1 = str1.substring(0, str1.length() - 1);
		digits = Integer.parseInt(str1);
		fireResultChanged();
		
		String str = String.valueOf(number);
		str = str.substring(0, str.length() - 1);
		number = Double.parseDouble(str);
		fireResultChanged();	

		
		
	}

	@Override
	public void inputSign() {
//		number *= -1;
	}
	
	@Override
	public void inputComma(Comma comma) {
		commaSet = true;
//		if (!lastInputWasOperation) {
//		String str = Double.toString(number) + sign.getSign();
//			String str = a + sign.getSign();
//			System.out.println(str);
//		}
	}

	// Zuweisung enum Werte zu Rechnung
	@Override
	public void inputOperator(Operator operator) {
		this.lastInputWasOperation = true;

		if (!operator.isInstant()) {
			if (numberReady) {
				number = switch (storedOperator) {
				// number = number2 + number;
				case PLUS -> number2 + number;
				case MINUS -> number2 - number;
				case MULTIPLY -> number2 * number;
				case DIVIDE -> number2 / number;
//				case DELETE -> throw new UnsupportedOperationException("Unimplemented case: " + this.operator);
//				case PERCENT -> number2 / 100;
//				case ROOT -> Math.sqrt(number2);
//				case POW -> Math.pow(this.number2, 2);
//				case EQUAL-> number2 + operator.getOperator() + number;
				default -> throw new IllegalArgumentException("Unexpected value: " + this.storedOperator);
				};
			}

			storedOperator = operator;
		} else {
			if (!numberReady) {
				number = switch (this.storedOperator) {
				case POW -> Math.pow(this.number, 2);
				case ROOT -> Math.sqrt(number);
				default -> throw new IllegalArgumentException("Unexpected value: " + this.storedOperator);
				};

			}
		}

		this.number2 = number;

		numberReady = false;
		commaCounter = 0;
		commaSet = false;
//		this.lastInputWasOperation = true;

		fireResultChanged();
//			switch (operator) {
//			case PLUS:
//				System.out.println(num1 + " + " + num2 + " = ");
//				num3 = num1 + num2;
//				System.out.println(num3);
//				return num3;
//			case MINUS:
//				System.out.println(num1 + " - " + num2 + " = ");
//				num3 = num1 - num2;
//				System.out.println(num3);
//				return num3;
//			case MULTIPLY:
//				num3 = num1 * num2;
//				return num3;
//			case DIVIDE:
//				num3 = num1 / num2;
//				return num3;
//			default:
//				throw new IllegalArgumentException("Unexpected value: " + operator);
//			}
		debug();
	}

	private void debug() {
		System.out.println(String.format("N: %f, N2: %f, OP: %s, LN: %s, NR: %s", number, number2, storedOperator,
				lastInputWasOperation, numberReady));
	}

	@Override
	public String getPath() {
//	if(numberReady) {
//		return number2 + " " + operator.getOperator();
//		}else
//	return operator.getOperator() +"(" +number2+")";

		if (Objects.equals(storedOperator, storedOperator.POW) || Objects.equals(storedOperator, storedOperator.ROOT)) {
			return storedOperator.getOperator() + "(" + number2 + ")";
		} else
			return number2 + " " + Optional.ofNullable(storedOperator).map(op -> op.getOperator()).orElse("");
	}

	@Override
	public double getResult() {
		return number;
	}

	@Override
	public double getEqual() {

		String op = this.storedOperator.getOperator();
		if (op.equals("+")) {
			return number2 + number;
		} else if (op.equals("-")) {
			return number2 - number;
		} else if (op.equals("x")) {
			return number2 * number;
		} else if (op.equals("÷")) {
			return number2 / number;
		}
		return this.number;

//		if(operator.PLUS) {
//			
//		}
	}

//
	private void fireResultChanged() {
		// for each
		for (ResultListener listener : resultListeners) {
			listener.resultChanged();
		}
	}

	@Override
	public void addResultListener(ResultListener listener) {
		resultListeners.add(listener);
	}

	@Override
	public double delAll() {
		return number2 = 0;

	}



}