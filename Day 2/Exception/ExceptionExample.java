public class ExceptionExample{
	
	public static void main(String[] args) {
		
		int[] arr = new int[5];

		System.out.println("Statement1");
		System.out.println("Statement2");
		System.out.println("Statement3");
		
		//arr[6]=10;	//If there code terminates here
		/*try{
			arr[6]=10; 	//which is exception
		}catch(ArrayIndexOutOfBoundsException e){		//in catch what is exception 	//ArrayIndexOutOfBoundsException is used only here
			System.err.println(e);		//to write in error
		}finally{		//To close the try-catch
			System.out.println("Finally Block");	//prints always
		}*/

		try{
			arr[6]=10; 	//which is exception
		}catch(Exception e){		//in catch what is exception 	//Exception can be used for all
			System.err.println(e);		//to write in error
		}finally{		//To close the try-catch
			System.out.println("Finally Block");	//prints always
		}
		

		System.out.println("Statement4");
		System.out.println("Statement5");
		System.out.println("Statement6");
	}
}