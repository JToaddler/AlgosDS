package com.leetcode.array;

import java.util.TreeMap;

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */

/**
 * https://leetcode.com/problems/snapshot-array
 * 
 * @author Anto
 *
 */
class SnapshotArray {

	int snap = 0;
	TreeMap<Integer, Integer>[] history;

	public SnapshotArray(int length) {
		history = new TreeMap[length];
		for (int i = 0; i < length; i++) {
			history[i] = new TreeMap<Integer, Integer>();
			history[i].put(0, 0);
		}
	}

	public void set(int index, int val) {
		history[index].put(snap, val);
	}

	public int snap() {
		return snap++;
	}

	public int get(int index, int snap_id) {
		return history[index].floorEntry(snap_id).getValue();
	}
}
