package com.ds.cache;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LFU_BF implements Cache<String, Object> {

	private int capacity;
	private Map<String, Object> data;
	private Map<String, Integer> counter;

	public LFU_BF(int size) {
		capacity = size;
		data = new ConcurrentHashMap<String, Object>();
		counter = new ConcurrentHashMap<String, Integer>();
	}

	@Override
	public void put(String key, Object value) {

		data.put(key, value);

		if (capacity <= data.size()) {
			int min = Integer.MAX_VALUE;
			for (Entry<String, Integer> set : counter.entrySet()) {
				min = Math.min(min, set.getValue());
			}
			for (Entry<String, Integer> set : counter.entrySet()) {
				if (set.getValue() == min) {
					counter.remove(set.getKey());
					data.remove(set.getKey());
					break;
				}
			}
		}
		counter.put(key, counter.getOrDefault(key, 0) + 1);
		System.out.println("Date :" + data + ", counter :" + counter);
	}

	@Override
	public Optional<Object> get(String key) {
		if (counter.containsKey(key))
			counter.put(key, counter.getOrDefault(key, 0) + 1);
		return Optional.ofNullable(counter.get(key));
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {

	}

	public static void main(String[] args) {
		LFU_BF cache = new LFU_BF(4);
		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("C", "Csdfgdfg");

		cache.get("A");
		cache.get("B");
		cache.get("C");

		cache.put("D", "Dsdfgdfg");

		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("E", "Easd");

	}

}
