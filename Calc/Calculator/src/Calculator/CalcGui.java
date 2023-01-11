package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcGui {

	// numbers
	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new BorderLayout());

	JButton btZero = new JButton("0");
	JButton btOne = new JButton("1");
	JButton btTwo = new JButton("2");
	JButton btThree = new JButton("3");
	JButton btFour = new JButton("4");
	JButton btFive = new JButton("5");
	JButton btSix = new JButton("6");
	JButton btSeven = new JButton("7");
	JButton btEight = new JButton("8");
	JButton btNine = new JButton("9");

	// operations
	JButton comma = new JButton(",");
	JButton equal = new JButton("=");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton multiply = new JButton("x");
	JButton divide = new JButton("÷");
	JButton delLast = new JButton("⌫");

	JButton oneDiv = new JButton("1/x");
	JButton sqr = new JButton("x²");
	JButton root = new JButton("√");
	JButton percentage = new JButton("%");
	JButton ce = new JButton("CE");
	JButton c = new JButton("C");
	JButton negOrPos = new JButton("±");

	JTextField tfCalc = new JTextField("0");

	JTextField tfPath = new JTextField();

	private CalculatorLogic logic;
	
	DecimalFormat df = new DecimalFormat("#,##0.################");

	public CalcGui(CalculatorLogic logic) {
		this.logic = logic;
		logic.addResultListener(() -> tfCalc.setText(df.format(logic.getResult())));
		logic.addResultListener(() -> tfPath.setText("" + logic.getPath()));

		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(400, 400));
		frame.setMinimumSize(new Dimension(350, 350));

//		frame.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				System.out.println("ZESO " + e);
//			}
//		});

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		gbc.gridx = 0;
		gbc.gridy = 0;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
//		double height = screenSize.getHeight();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(7, 7, 7, 7);

		// numbers
		gbc.gridx = 1;
		gbc.gridy = 7;
		Font font = new Font("Arial", Font.PLAIN, 16);
		btZero.setFont(font);
		panel.add(btZero, gbc);
		btZero.addActionListener(event -> logic.inputNumber(Digit.ZERO));

		gbc.gridx = 0;
		gbc.gridy = 6;
		btOne.setFont(font);
		panel.add(btOne, gbc);
		btOne.addActionListener(event -> logic.inputNumber(Digit.ONE));

		gbc.gridx = 1;
		gbc.gridy = 6;
		btTwo.setFont(font);
		panel.add(btTwo, gbc);
		btTwo.addActionListener(event -> logic.inputNumber(Digit.TWO));

		gbc.gridx = 2;
		gbc.gridy = 6;
		btThree.setFont(font);
		panel.add(btThree, gbc);
		btThree.addActionListener(event -> logic.inputNumber(Digit.THREE));

		gbc.gridx = 0;
		gbc.gridy = 5;
		btFour.setFont(font);
		panel.add(btFour, gbc);
		btFour.addActionListener(event -> logic.inputNumber(Digit.FOUR));

		gbc.gridx = 1;
		gbc.gridy = 5;
		btFive.setFont(font);
		panel.add(btFive, gbc);
		btFive.addActionListener(event -> logic.inputNumber(Digit.FIVE));

		gbc.gridx = 2;
		gbc.gridy = 5;
		btSix.setFont(font);
		panel.add(btSix, gbc);
		btSix.addActionListener(event -> logic.inputNumber(Digit.SIX));

		gbc.gridx = 0;
		gbc.gridy = 4;
		btSeven.setFont(font);
		panel.add(btSeven, gbc);
		btSeven.addActionListener(event -> logic.inputNumber(Digit.SEVEN));

		gbc.gridx = 1;
		gbc.gridy = 4;
		btEight.setFont(font);
		panel.add(btEight, gbc);
		btEight.addActionListener(event -> logic.inputNumber(Digit.EIGHT));

		gbc.gridx = 2;
		gbc.gridy = 4;
		btNine.setFont(font);
		panel.add(btNine, gbc);
		btNine.addActionListener(event -> logic.inputNumber(Digit.NINE));

		// operations
		gbc.gridx = 3;
		gbc.gridy = 6;
		plus.setFont(font);
		panel.add(plus, gbc);
		plus.addActionListener(e -> logic.inputOperator(Operator.PLUS));

		gbc.gridx = 3;
		gbc.gridy = 5;
		minus.setFont(font);
		panel.add(minus, gbc);
		minus.addActionListener(e -> logic.inputOperator(Operator.MINUS));

		gbc.gridx = 3;
		gbc.gridy = 4;
		multiply.setFont(font);
		panel.add(multiply, gbc);
		multiply.addActionListener(e -> logic.inputOperator(Operator.MULTIPLY));

		gbc.gridx = 3;
		gbc.gridy = 3;
		divide.setFont(font);
		panel.add(divide, gbc);
		divide.addActionListener(e -> logic.inputOperator(Operator.DIVIDE));

		gbc.gridx = 3;
		gbc.gridy = 7;
		equal.setFont(font);
		panel.add(equal, gbc);
		equal.addActionListener(e -> {
			logic.getEqual();
			tfPath.setText(logic.getPath() + " " + logic.getResult());
			tfCalc.setText(""+logic.getEqual());
			
			
		});

		gbc.gridx = 3;
		gbc.gridy = 2;
		delLast.setFont(font);
		panel.add(delLast, gbc);
		delLast.addActionListener(e-> logic.deleteDigit());

		gbc.gridx = 0;
		gbc.gridy = 3;
		oneDiv.setFont(font);
		panel.add(oneDiv, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 3;
		sqr.setFont(font);
		panel.add(sqr, gbc);
		sqr.addActionListener(e -> logic.inputOperator(Operator.POW));

		gbc.gridx = 2;
		gbc.gridy = 3;
		root.setFont(font);
		panel.add(root, gbc);
		root.addActionListener(e -> logic.inputOperator(Operator.ROOT));

		gbc.gridx = 0;
		gbc.gridy = 2;
		percentage.setFont(font);
		panel.add(percentage, gbc);
		percentage.addActionListener(e -> logic.inputOperator(Operator.PERCENT));

		gbc.gridx = 1;
		gbc.gridy = 2;
		ce.setFont(font);
		panel.add(ce, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		c.setFont(font);
		panel.add(c, gbc);
//		c.addActionListener(e -> tfCalc.setText(""+logic.delAll()));

		gbc.gridx = 0;
		gbc.gridy = 7;
		negOrPos.setFont(font);
		panel.add(negOrPos, gbc);

		gbc.gridx = 2;
		gbc.gridy = 7;
		comma.setFont(font);
		panel.add(comma, gbc);
		comma.addActionListener(e-> logic.inputComma(Comma.COMMA));


		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth += 3;
		tfCalc.setFont(font);
		tfCalc.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(tfCalc, gbc);

//		tfCalc.addActionListener(
//				e -> logic.mult(Integer.parseInt(tfCalc.getText()), Integer.parseInt(tfCalc.getText())));

		gbc.gridx = 0;
		gbc.gridy = 0;
		tfPath.setFont(new Font("Arial", Font.PLAIN, (int) width / 200));
		tfPath.setHorizontalAlignment(JTextField.RIGHT);
		tfPath.setEditable(false);
		tfPath.setBorder(null);
		panel.add(tfPath, gbc);
//		tfPath.addActionListener(e->);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public void init() {
	}

}
