public class Fraction<T> {
	private T numerator;
	private T denominator;

	public Fraction(){
		//this.numerator = 0.0;
		//this.denominator = 1.0;
	}

	public Fraction(T numerator, T denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(String s){
		//String[] numbers = s.split("/");
		//this.numerator = Integer.parseInt(numbers[0]);
		//this.denominator = Integer.parseInt(numbers[1]);
	}

	public void setNumerator(T numerator){
		this.numerator = numerator;
	}

	public void setDenominator(T denominator){
		this.denominator = denominator;
	}

	public void setFraction(String s){
		//String[] numbers = s.split("/");
		//this.numerator = Integer.parseInt(numbers[0]);
		//this.denominator = Integer.parseInt(numbers[1]);
	}

	public T getNumerator(){
		return this.numerator;
	}

	public T getDenominator(){
		return this.denominator;
	}

	public void printFraction(){
		System.out.println(this.numerator+"/"+this.denominator);
	}

	//public Double getValue(){
		//return (Double) numerator/denominator;
	//}
}