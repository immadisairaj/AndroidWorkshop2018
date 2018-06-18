import java.util.Scanner;

public class TakeInput{
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);		//Refer java documentation for constructors

		//String
		String name = userInput.nextLine();		//For whole line
		String name2 = userInput.next();		//Part before space
		System.out.println("Hello "+name+" "+name2);

		//userInput.nextLine();		//For curser to go to next 	//This is used if the above statement has more than one word

		//int
		int age = userInput.nextInt();
		System.out.println("I am "+age+" years old");

		//double
		double variable = userInput.nextDouble();
		System.out.println(variable);

		//float
		float abc = userInput.nextFloat();
		System.out.println(abc);

		userInput.close();								//Close the Scanner only after comple use of Scanner
	}
}