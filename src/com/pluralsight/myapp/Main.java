package com.pluralsight.myapp;


import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {
//	    double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//	    double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//	    char[] opCodes = {'d', 'a', 's', 'm'};
//	    double[] results = new double[opCodes.length];
		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation('d', 50.0, 50.0);
		equations[1] = new MathEquation('a', 92.0, 25.0);
		equations[2] = new MathEquation('s', 17.0, 225.0);
		equations[3] = new MathEquation('m', 3.0, 11.0);

		String[] statements = {
				"add 1.0", // Error:incorrect number of values
				"add xx 25.0", // Error:non-numeric data
				"addX 0.0 0.0", // Error: invalid command
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"subtract 225.0 17.0",
				"multiply 11.0 3.0"
		};

		CalculateHelper helper = new CalculateHelper();
		for(String statement:statements) {
			try {
				helper.process(statement);
				System.out.println(helper);
			} catch (InvalidStatementException e) {
				System.out.println(e.getMessage());
				if (e.getCause() != null)
					System.out.println("  Original exception: " + e.getCause().getMessage());
			}
		}
	    for(MathEquation equation: equations) {
	    	equation.execute();
	        System.out.println("result = ");
	        System.out.println(equation.getResult());
    }
	    double leftDouble = 9.0d;
	    double rightDouble = 4.0d;
	    int leftInt = 9;
	    int rightInt = 4;

	    MathEquation equationOverload = new MathEquation('d');

	    equationOverload.execute(leftDouble, rightDouble);
	    System.out.println("result = ");
	    System.out.println(equationOverload.getResult());

		equationOverload.execute(leftInt, rightInt);
		System.out.println("result = ");
		System.out.println(equationOverload.getResult());

		equationOverload.execute((double)leftInt, rightInt);
		System.out.println("result = ");
		System.out.println(equationOverload.getResult());

		System.out.println();
		System.out.println("Using inheritance");

		CalculateBase[] calculators = {
				new Divider(100.0d, 50.0d),
				new Adder(25.0d, 92.0d),
				new Subtractor(225.0d, 17.0d),
				new Multiplier(11.0d, 3.0d)
		};

		for (CalculateBase calculator:calculators) {
			calculator.calculate();
			System.out.println("result=");
			System.out.println(calculator.getResult());
		}
}

}
