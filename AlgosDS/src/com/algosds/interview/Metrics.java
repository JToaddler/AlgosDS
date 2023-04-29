package com.algosds.interview;

public class Metrics {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Metrics(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Metrics(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " ";
	}

	public boolean equals(Metrics m) {
		if (m != null && this.id == m.id) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}
}
