package com.algosds.interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class MetricsService implements Set<Metrics> {

	private Metrics[] metrics;

	public MetricsService(Metrics unit) {
		Metrics[] newMetrics = new Metrics[1];
		this.metrics = newMetrics;
		metrics[0] = unit;
	}

	@Override
	public int size() {
		System.out.println("Metrics set size : " + metrics.length);
		return metrics.length;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public int indexOf(Metrics[] ms, Object o) {

		Metrics metrics = (Metrics) o;
		int index = Arrays.binarySearch(ms, metrics, new Comparator<Metrics>() {
			public int compare(Metrics m1, Metrics m2) {
				return m1.getId() - m2.getId();
			}
		});
		return index;
	}

	@Override
	public boolean contains(Object o) {
		Metrics metrics = (Metrics) o;
		int index = this.indexOf(this.metrics, metrics);
		return index >= 0 ? true : false;
	}

	@Override
	public Iterator<Metrics> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(Metrics e) {
		boolean isAdded = false;
		int index = this.indexOf(this.metrics, e);
		Metrics[] newMetrics = new Metrics[this.metrics.length + 1];
		if (index < 0) {
			for (int i = 0; i < this.metrics.length; i++) {
				newMetrics[i] = this.metrics[i];
			}
			newMetrics[this.metrics.length] = e;
			this.metrics = newMetrics;
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean remove(Object o) {
		int index = this.indexOf(this.metrics, (Metrics) o);
		boolean isRemoved = false;
		if (index >= 0) {
			Metrics[] newMetrics = new Metrics[this.metrics.length - 1];
			for (int i = 0; i <= this.metrics.length - 1; i++) {
				if (i == index) {
					isRemoved = true;
				} else {
					if (!isRemoved)
						newMetrics[i] = this.metrics[i];
					if (isRemoved)
						newMetrics[i - 1] = this.metrics[i];
				}
			}
			this.metrics = newMetrics;
			System.out.println("After removing :" + o + " Metrics = " + this);
		}
		return isRemoved;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Metrics> coll) {

		boolean isAddedAll = false;
		Object[] subset = coll.toArray();
		int count = 0;
		for (int i = 0; i < subset.length; i++) {
			boolean isAdded = this.add((Metrics) subset[i]);
			count = isAdded ? count + 1 : count;
		}
		if (count == subset.length) {
			isAddedAll = true;
		}
		return isAddedAll;
	}

	@Override
	public boolean retainAll(Collection<?> colls) {

		Object[] subArray = colls.toArray();
		Metrics[] mArray = new Metrics[subArray.length];
		for (int i = 0; i < mArray.length; i++)
			mArray[i] = (Metrics) subArray[i];
		boolean isChanged = false;
		for (int i = 0; i < mArray.length; i++) {
			int index = this.indexOf(this.metrics, mArray[i]);
			if (index < 0) {
				this.remove(this.metrics[i]);
				isChanged = true;
			}
		}
		for (int i = 0; i < this.metrics.length; i++) {
			int index = this.indexOf(mArray, this.metrics[i]);
			if (index < 0) {
				this.remove(this.metrics[i]);
				isChanged = true;
			}
		}
		return isChanged;
	}

	@Override
	public boolean removeAll(Collection<?> coll) {
		boolean isRemovedAll = false;
		int count = 0;
		Object[] objArray = coll.toArray();
		for (int i = 0; i < objArray.length; i++) {
			boolean isRemoved = this.remove(objArray[i]);
			count = isRemoved ? count + 1 : count;
			if (count == objArray.length) {
				isRemovedAll = true;
			}
		}
		return isRemovedAll;
	}

	@Override
	public void clear() {

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.metrics.length; i++) {
			sb.append(this.metrics[i].getId() + " ");
		}
		return sb.toString();
	}

}
