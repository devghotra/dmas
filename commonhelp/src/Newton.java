import java.text.DecimalFormat;
import java.util.Scanner;

public class Newton {

	public static float Compute(float num) {
		float accuracy = 0.000001f;
		
		float calculation = num/2;
		float sqrRoot = calculation;
		
		do {
			calculation = sqrRoot;
			sqrRoot = applyNewtonFormula(num, calculation);
		} while(Math.abs(sqrRoot - calculation) > accuracy);
		
		
		return sqrRoot;

	}
	
	public static float applyNewtonFormula(float num, float lastCalulation) {
		return lastCalulation - (lastCalulation*lastCalulation - num)/(2*lastCalulation) ;
	}

	public static void main(String[] args) {

		// declare a Scanner class object

		Scanner sc = new Scanner(System.in);

		// declare a DecimalFormat class object

		DecimalFormat fourDecimal = new DecimalFormat("0.0000");

		float Number = 0;

		System.out.println("Program: find square roots by Newton's Method");

		System.out.println("Please enter a number: ");

		Number = sc.nextFloat();

		System.out.println("The square root of " + Number + " is "
				+ fourDecimal.format(Compute(Number)));

	}

}
