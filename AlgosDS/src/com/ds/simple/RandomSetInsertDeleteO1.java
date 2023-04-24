package com.ds.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://www.youtube.com/watch?v=TD2g8UjXMLA&list=PLn1T1egVXVBDthyLvIRb7MiC36Az4Iejl
 * 
 * all functions O(1)
 * 
 * this can be implemented with HashSet interface as all operation of set is
 * O(1). But equal distributions to get element from set not possible as Set
 * does not maintain order.
 *
 * Convert Set -> List to get the random (equal dist)
 *
 * We have to implement three different functions: insert, remove, and get
 * random. Insert will take a value and insert it inside of a data structure.
 * Remove will take a value and remove it from the data structure. Get random
 * will return a random element from our data structure where each element must
 * have an equal probability of being chosen.
 * 
 * The time complexity of the optimal approach will be O(1) constant time since
 * we are using a map to store the elements with their appropriate indices and
 * only removing the last element in our arraylist. The space complexity will be
 * linear where N is the number of entries we have in our map and list.
 *
 */

public class RandomSetInsertDeleteO1 {

	private Map<Integer, Integer> map;
	private List<Integer> list;
	private Random random;

	public RandomSetInsertDeleteO1() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
		random = new Random();
	}

	public boolean insert(int value) {
		if (map.containsKey(value))
			return false;
		list.add(value);
		map.put(value, list.size());
		return true;
	}

	public boolean delete(int value) {

		if (!map.containsKey(value)) {
			return false;
		}
		int index = map.get(value);
		int last = list.get(list.size() - 1);
		list.set(index, last);
		list.set(list.size() - 1, value);
		map.put(last, index);

		list.remove(list.size() - 1);
		map.remove(value);
		return true;

	}

	public int getRandom() {
		int index = random.nextInt(Math.abs(list.size()));
		return list.get(index);
	}

	public static void main(String[] args) {
		RandomSetInsertDeleteO1 rand = new RandomSetInsertDeleteO1();

		rand.insert(2);
		rand.insert(3);
		rand.insert(4);
		rand.insert(6);

		System.out.println(rand.list + " " + rand.map);
		System.out.println("Random : " + rand.getRandom());

	}

}