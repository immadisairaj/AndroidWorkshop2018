import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestHashMap{
	public static void main(String[] args) {
		HashMap<Integer,String> hm = new HashMap<>();

		hm.put(1,"Abc");
		hm.put(2,"Bcd");
		hm.put(3,"Cde");

		Iterator<Map.Entry<Integer,String>> it = hm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,String> pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}

		String name = hm.get(2);
		System.out.println(name);
	}
}