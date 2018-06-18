//import java.util.Scanner;

public class TestFraction{

	/*public static double getDeterminant(double arr[][], int n){
		if(n==1){
			return arr[0][0];
		}
		else if(n==2){
			return (arr[0][0]*arr[1][1])-(arr[0][1]*arr[1][0]);
		}
		else{
			double det = 0;
			for(int k=0;k<n;k++){
				double[][] ar = new double[n-1][n-1];
				int x=0,y=0;
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(i!=0 && j!=k){
							ar[x][y++] = arr[i][j];
						}
						if(y == n-1){
							x++;
							y=0;
						}
					}
				}
				if(k%2 == 0){
					det+=arr[0][k]*getDeterminant(ar,n-1);
				}
				else{
					det-=arr[0][k]*getDeterminant(ar,n-1);
				}
			}
			return det;
		}
	}*/

	/*public static double computeValue(Fraction fractions[][]){
		double[][] arr = new double[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = fractions[i][j].getValue();
			}
		}
		return getDeterminant(arr,3);
	}*/
	
	public static void main(String[] args) {
		Fraction<Integer> fraction = new Fraction(2,3);
		Fraction<Double> f1 = new Fraction(4.0,5.0);

		fraction.printFraction();
		f1.printFraction();
	}
}