package leetcode.model;

public class DoublyListNode {
	int val;
	public DoublyListNode next, prev;

	public DoublyListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		DoublyListNode cur = this;
		while (cur != null) {
			sb.append(" " + cur.val);
			cur = cur.next;
		}
		return sb.append("]").toString();
	}

}
