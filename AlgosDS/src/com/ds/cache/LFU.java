package com.ds.cache;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LFU implements Cache<String, Object> {

	private int capacity;
	private Map<String, Object> data;
	private Map<String, Integer> counter;

	public LFU(int size) {
		capacity = size;
		data = new ConcurrentHashMap<String, Object>();
		counter = new ConcurrentHashMap<String, Integer>();
	}

	@Override
	public void put(String key, Object value) {

		data.put(key, value);
		counter.put(key, counter.getOrDefault(key, 0) + 1);
		System.out.println("Date :" + data + ", counter :" + counter);
		if (capacity <= data.size()) {
			int min = Integer.MAX_VALUE;
			for (Entry<String, Integer> set : counter.entrySet()) {
				min = Math.min(min, set.getValue());
			}
			for (Entry<String, Integer> set : counter.entrySet()) {
				if (set.getValue() == min) {
					counter.remove(set.getKey());
					data.remove(set.getKey());
				}
			}
		}
	}

	@Override
	public Optional<Object> get(String key) {
		return null;
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
		LFU cache = new LFU(4);
		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("C", "Csdfgdfg");

		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("C", "Csdfgdfg");

		cache.put("D", "Dsdfgdfg");

		cache.put("A", "Asdfds");
		cache.put("B", "Basd");
		cache.put("E", "Easd");
	}

}
