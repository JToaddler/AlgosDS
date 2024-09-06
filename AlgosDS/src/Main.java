import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3 };
		topKFrequent(nums, 2);

	}

	public static int[] topKFrequent(int[] nums, int k) {
		if (nums.length == 1)
			return nums;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			int count = map.getOrDefault(i, 0) + 1;
			map.put(i, count);
		}
		System.out.println(map);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n1));

		for (int i : nums) {
			minHeap.add(i);
			if (minHeap.size() > k)
				minHeap.poll();
		}
		System.out.println(minHeap);
		int[] arr = new int[k];
		int i = 0;
		while (i < k) {
			arr[i] = minHeap.poll();
			i++;
		}
		return arr;
	}

}
