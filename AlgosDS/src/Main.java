import java.util.LinkedList;

public class Main {

	private String val;

	public Main(String id) {
		this.val = id;
	}

	@Override
	public String toString() {
		return "Main [val=" + val + "] ";
	}

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0, 1);
		list.add(list.size() - 1, 2);
		System.out.println(list);
	}

}
