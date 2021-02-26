package com.pluralsight.calcengine;

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
