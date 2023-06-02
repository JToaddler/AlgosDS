package com.ds.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

public class LFU implements Cache<String, Object> {

	private int capacity;
	private Map<String, Object> cache;
	private Map<String, Integer> count;
	private TreeMap<Integer, LinkedList<String>> groupCounter;

	public LFU(int size) {
		capacity = size;
		cache = new HashMap<String, Object>(size);
		count = new HashMap<String, Integer>(size);
		groupCounter = new TreeMap<Integer, LinkedList<String>>();
	}

	@Override
	public void put(String key, Object value) {

		if (!cache.containsKey(key) && capacity <= cache.size()) {
			evict();
		}
		cache.put(key, value);
		get(key);
		System.out.println("Cache : " + cache + " Counter: " + count + " Grp: " + groupCounter);
	}

	public void evict() {
		if (cache.size() == 0)
			return;
		Entry<Integer, LinkedList<String>> entry = groupCounter.pollFirstEntry();
		LinkedList<String> grp = entry.getValue();
		String key = grp.remove();
		cache.remove(key);
		count.remove(key);
		if (grp.size() != 0)
			groupCounter.put(entry.getKey(), grp);
	}

	@Override
	public Optional<Object> get(String key) {

		if (cache.containsKey(key)) {
			count.put(key, count.getOrDefault(key, 0) + 1);
			groupCounter.putIfAbsent(count.get(key), new LinkedList<String>());
			groupCounter.get(count.get(key)).add(key);
		}
		if (groupCounter.containsKey(count.get(key) - 1))
			groupCounter.get(count.get(key) - 1).remove(key);

		if (groupCounter.containsKey(count.get(key) - 1) && groupCounter.get(count.get(key) - 1).size() == 0)
			groupCounter.remove(count.get(key) - 1);

		return Optional.ofNullable(cache.get(key));
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return cache.isEmpty();
	}

	@Override
	public void clear() {
		cache = new HashMap<String, Object>();
		count = new HashMap<String, Integer>();
		groupCounter = new TreeMap<Integer, LinkedList<String>>();
	}

	public static void main(String[] args) {
		LFU cache = new LFU(3);
		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("C", "Csdfgdfg");

		cache.get("A");
		cache.get("B");
		cache.get("C");

		cache.get("A");
		cache.get("A");
		cache.get("A");

		cache.put("A", "Asdfds");
		cache.put("D", "Dsdfgdfg");
		cache.put("E", "Dsdfgdfg");

		cache.put("A", "Asdfds");
	}

}
