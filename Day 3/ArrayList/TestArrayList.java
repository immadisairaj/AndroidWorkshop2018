import java.util.ArrayList;

public class TestArrayList{
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();

		al.add(2);
		al.add(3);
		al.add(4);

		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}
	}
}