package com.ds.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LFUCache {

	private int size;
	private Map<Integer, Integer> cache;
	private Map<Integer, Integer> count;
	private TreeMap<Integer, LinkedList<Integer>> groupCounter;

	public LFUCache(int capacity) {
		size = capacity;
		cache = new HashMap<Integer, Integer>();
		count = new HashMap<Integer, Integer>();
		groupCounter = new TreeMap<Integer, LinkedList<Integer>>();
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		if (cache.containsKey(key)) {
			count.put(key, count.getOrDefault(key, 0) + 1);
			groupCounter.putIfAbsent(count.get(key), new LinkedList<Integer>());
			groupCounter.get(count.get(key)).add(key);
		}
		if (groupCounter.containsKey(count.get(key) - 1))
			groupCounter.get(count.get(key) - 1).remove(Integer.valueOf(key));

		if (groupCounter.containsKey(count.get(key) - 1) && groupCounter.get(count.get(key) - 1).size() == 0)
			groupCounter.remove(count.get(key) - 1);

		return cache.getOrDefault(key, -1);
	}

	public void evict() {
		if (cache.size() == 0)
			return;
		Entry<Integer, LinkedList<Integer>> entry = groupCounter.pollFirstEntry();
		LinkedList<Integer> grp = entry.getValue();
		Integer key = grp.remove();
		cache.remove(key);
		count.remove(key);
		if (grp.size() != 0)
			groupCounter.put(entry.getKey(), grp);
	}

	public void put(int key, int value) {
		if (!cache.containsKey(key) && size <= cache.size()) {
			evict();
		}
		cache.put(key, value);
		get(key);
		System.out.println("Cache : " + cache + " Counter: " + count + " Grp: " + groupCounter);
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 2);

		cache.get(1);
		cache.get(2);
		cache.get(3);

		cache.get(1);
		cache.get(1);
		cache.get(1);

		cache.put(1, 1);
		cache.put(4, 4);
		cache.put(5, 5);

		cache.put(1, 1);
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */