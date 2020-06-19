import java.util.Arrays;
import java.util.LinkedList;

public class Tuple {

	String output;
	LinkedList<String> list;
	
	public Tuple() {
		list = new LinkedList<String>();
	}
	
	void addToList(String type,String predicate, String argument) {
		output = type + " " + predicate + " " + argument;
		list.add(output);
	}
	
	void printList() {
		System.out.println(Arrays.toString(list.toArray()));
	}
	
//	public static void main(String [] args) {
//		Tuple x = new Tuple();
//		x.addToList("NN", "answer", "2.0");
//		x.printList();
//		
//	}
}
