package com.algosds.interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * https://github.com/deepak-malik/Data-Structures-In-Java/blob/master/src/com/deepak/data/structures/Set/ArrayBasedSet.java
 * 
 * 
 * @author Anto
 *
 */
public class MetricsService implements Set<Metrics> {

	private final int MIN_ARRAY_CAPACITY = 5;
	private Metrics[] metrics;
	private int size = 0;

	public MetricsService() {
		Metrics[] newMetrics = new Metrics[MIN_ARRAY_CAPACITY];
		this.metrics = newMetrics;
	}

	public MetricsService(Metrics unit) {
		this();
		metrics[0] = unit;
		size++;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		int index = -1;
		if (o instanceof Metrics) {
			index = this.indexOf((Metrics) o);
		}
		return index >= 0;
	}

	@Override
	public Iterator<Metrics> iterator() {
		return Arrays.asList(this.metrics).iterator();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOfRange(this.metrics, 0, this.size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (this.size < a.length) {
			throw new IndexOutOfBoundsException("");
		}
		return (T[]) Arrays.copyOfRange(this.metrics, 0, a.length > this.size ? this.size : a.length);
	}

	@Override
	public boolean add(Metrics e) {
		int index = this.indexOf(e);
		if (index < 0) {
			ensureCapacity();
			this.metrics[this.size] = e;
			this.size++;
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * Get the index of the target to be deleted.
	 * 
	 * In the target index, add the last element in the array. Update null in the
	 * last array
	 * 
	 * So O(n) still required. to identify the indexOf(target)
	 *
	 */
	@Override
	public boolean remove(Object o) {
		int index = this.indexOf((Metrics) o);
		if (index >= 0) {
			Metrics last = this.metrics[this.size - 1];
			this.metrics[index] = last;
			this.metrics[this.size - 1] = null;
			this.size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c.size() == 0) {
			return false;
		}
		long count = c.stream().map(element -> {
			return this.contains(element);
		}).filter(result -> {
			return result == false;
		}).distinct().count();
		return count == 0 ? true : false;
	}

	@Override
	public boolean addAll(Collection<? extends Metrics> c) {
		long isDuplicatePresent = c.stream().map(element -> {
			return this.add(element);
		}).filter(result -> {
			return result == false;
		}).count();
		return isDuplicatePresent == 0 ? true : false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		long resultCount = c.stream().map(element -> {
			return this.remove(element);
		}).filter(result -> {
			return result == false;
		}).count();
		return resultCount == 0 ? true : false;
	}

	@Override
	public void clear() {
		this.metrics = new Metrics[this.MIN_ARRAY_CAPACITY];
		this.size = 0;
	}

	public int indexOf(Metrics e) {
		int index = -1;
		if (e == null) {
			for (int i = 0; i < this.size; i++) {
				if (this.metrics[i] == null) {
					index = i;
				}
			}
		} else {
			for (int i = 0; i < this.size; i++) {
				if (this.metrics[i] != null && this.metrics[i].equals(e)) {
					index = i;
				}
			}
		}
		return index;
	}

	private void ensureCapacity() {
		if (this.size == this.metrics.length) {
			int newCapacity = this.size * 2;
			Metrics[] newMetric = Arrays.copyOf(this.metrics, newCapacity);
			this.metrics = newMetric;
			System.out.println("Array size increamented to " + newCapacity);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			sb.append(this.metrics[i] + " ");
		}
		return sb.toString();
	}

}
