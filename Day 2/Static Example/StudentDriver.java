public class StudentDriver{
	
	public static void main(String args[]){
		
		//ClassName.variable -> Static Variable
		Student.universityName = "Amrita";
		
		Student student1 = new Student(16002,"Yo");
		Student student2 = new Student(16003,"Lol");

		student1.getStudentDetails();
		student2.getStudentDetails();

		//ClassName.method -> Static Metod
		Student.printSomething();
	}
}