import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

		Queue<Integer> maxHeap = new PriorityQueue<Integer>((num1, num2) -> {
			return num2 - num1;
		});
		maxHeap.add(5);
		maxHeap.add(8);
		maxHeap.add(4);
		maxHeap.add(12);
		maxHeap.add(9);

		System.out.println(Arrays.toString(maxHeap.toArray()));

	}

}
