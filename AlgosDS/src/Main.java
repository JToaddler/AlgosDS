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

		Main m = new Main();
		Node newNode = m.new Node(1, null);

		m.front = newNode;
		m.rear = newNode;

		m.rear.next = m.new Node(2, null);
		System.out.println(m.front.next.val);

		for (int i = 0; i < m.intArray.length; i++) {
			System.out.print(m.intArray[i]);
		}
	}

}
