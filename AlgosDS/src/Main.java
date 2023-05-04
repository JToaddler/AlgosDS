import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	private String val;
	private int[] intArray = new int[4];

	Node front;
	Node rear;
	int size;

	class Node {
		Object val;
		Node next;

		public Node(int data, Node next) {
			this.val = data;
			this.next = next;
		}

	}

	public static void main(String[] args) {
		Set<List<Integer>> setInts = new HashSet<List<Integer>>();
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		System.out.println(setInts.add(intList));

		intList = new ArrayList<Integer>();
		intList.add(2);
		intList.add(1);
		System.out.println(setInts.add(intList));

		intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(1);
		System.out.println(setInts.add(intList));
	}

}
