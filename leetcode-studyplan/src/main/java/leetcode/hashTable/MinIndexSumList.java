package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinIndexSumList {

	public static void main(String... args) {

		findRestaurant(new String[] { "happy", "sad", "good" }, new String[] { "sad", "happy", "good" });

	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, List<Integer>> map = new HashMap<>();
		Map<Integer, List<String>> rankMap = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			List<Integer> indexList = map.getOrDefault(list1[i], new ArrayList<Integer>());
			indexList.add(i);
			map.putIfAbsent(list1[i], indexList);
		}
		int minRank = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int rank = map.get(list2[i]).get(0) + i;
				List<String> keys = rankMap.getOrDefault(rank, new ArrayList<String>());
				rankMap.putIfAbsent(rank, keys);
				minRank = Math.min(minRank, rank);
			}
		}
		List<String> list = rankMap.get(minRank);
		String[] res = new String[list.size()];
		return list.toArray(res);
	}
}
