package com.ds.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LRU implements Cache<String, Object> {

	Map<String, Object> data = null;
	LinkedList<String> order = null;
	private int capacity;

	public LRU(int size) {
		data = new ConcurrentHashMap<String, Object>(size);
		order = new LinkedList<String>();
		capacity = size;
	}

	public void put(String key, Object value) {
		if (capacity <= data.size()) {
			String lruKey = order.removeLast();
			data.remove(lruKey);
		}
		data.put(key, value);
		order.addFirst(key);
		System.out.println("Data :" + data + ",  Order:" + order);
	}

	public Optional<Object> get(String key) {
		Optional<Object> entry = Optional.ofNullable(data.get(key));
		if (entry.isPresent()) {
			order.remove(key);
			order.addFirst(key);
		}
		return entry;
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void clear() {
		data = new HashMap<String, Object>(capacity);
		order = new LinkedList<String>();
	}

	public static void main(String[] args) {

		LRU lru = new LRU(3);
		lru.put("A", "asdasd");
		lru.put("B", "bsdfsdfd");
		lru.put("C", "Cds213213sdfd");
		lru.put("D", "Ddfg213213sdfd");
		System.out.println(lru.get("B"));
		System.out.println("Data :" + lru.data + ",  Order:" + lru.order);
	}

}
