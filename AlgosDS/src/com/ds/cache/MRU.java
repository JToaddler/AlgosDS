package com.ds.cache;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MRU implements Cache<String, Object> {

	private int capacity;
	private LinkedList<String> order;
	private Map<String, Object> data;

	public MRU(int size) {
		capacity = size;
		order = new LinkedList<>();
		data = new ConcurrentHashMap<>(capacity);
	}

	public void put(String key, Object value) {
		if (capacity <= data.size()) {
			String mru = order.removeLast();
			data.remove(mru);
		}
		data.put(key, value);
		order.addLast(key);
		System.out.println("Data :" + data + ",  Order:" + order);
	}

	public Optional<Object> get(String key) {
		Optional<Object> result = Optional.ofNullable(data.get(key));
		if (result.isPresent()) {
			order.remove(key);
			order.addLast(key);
		}
		return result;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	public void clear() {

	}

	public static void main(String[] args) {
		MRU mru = new MRU(3);
		mru.put("1", "12");
		mru.put("2", "23");
		mru.put("3", "34");
		mru.put("4", "45");
		System.out.println(mru.get("1"));
		System.out.println("Data :" + mru.data + ",  Order:" + mru.order);
	}

}
