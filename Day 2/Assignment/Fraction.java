public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(){
		this.numerator = 0;
		this.denominator = 1;
	}

	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(String s){
		String[] numbers = s.split("/");
		this.numerator = Integer.parseInt(numbers[0]);
		this.denominator = Integer.parseInt(numbers[1]);
	}

	public void setNumerator(int numerator){
		this.numerator = numerator;
	}

	public void setDenominator(int denominator){
		this.denominator = denominator;
	}

	public void setFraction(String s){
		String[] numbers = s.split("/");
		this.numerator = Integer.parseInt(numbers[0]);
		this.denominator = Integer.parseInt(numbers[1]);
	}

	public int getNumerator(){
		return this.numerator;
	}

	public int getDenominator(){
		return this.denominator;
	}

	public double getValue(){
		return (double) this.numerator/this.denominator;
	}
}