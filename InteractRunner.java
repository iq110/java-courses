import java.util.Scanner;

/**
	Eeann aey caionea eaeueoeyoi?a. Iiaaa??eaaao aaia iieuciaaoaey.
*/
public class InteractRunner {
	
	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		try {
			Calculator calc = new Calculator();
			String exit = "no";
			while (!exit.equals("yes")) {
				System.out.println("Enter first arg : ");
				String first = reader.next();
				System.out.println("Enter second arg : ");
				String second = reader.next();
				System.out.println("Case action: 1.+ 2.- 3.* 4./ 5.^");
				int action = Integer.valueOf(reader.next());
				switch (action){
					case 1:
					calc.add(Integer.valueOf(first), Integer.valueOf(second));
					break;
					
					case 2:
					calc.minus(Integer.valueOf(first), Integer.valueOf(second));
					break;
					
					case 3:
					calc.multiply(Integer.valueOf(first), Integer.valueOf(second));
					break;
					
					case 4:
					calc.div(Integer.valueOf(first), Integer.valueOf(second));
					break;
					
					case 5:
					calc.pow(Integer.valueOf(first), Integer.valueOf(second));
					break;
				}
				System.out.println("Result : " + calc.getResult());
				calc.cleanResult();
				System.out.println("Exit : yes/no ");
				exit = reader.next();
			}
		} finally {
			reader.close();
		}
	}
}