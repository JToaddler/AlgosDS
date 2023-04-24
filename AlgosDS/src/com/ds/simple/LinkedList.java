package com.ds.simple;

/**
 * LinkedList implementation
 * 
 * https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * 
 * @author Anto
 *
 */
public class LinkedList {

	LinkedNode head;

	public void insert(LinkedList list, int data) {

		LinkedNode newNode = new LinkedNode(data);
		if (list.head == null) {
			list.head = newNode;
			System.out.println("Inserted value at head: " + data);
		} else {
			LinkedNode last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			System.out.println("Inserted " + last.next.data + " After " + last.data);
		}
	}

	public void printLinkedList(LinkedList list) {

		LinkedNode node = list.head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		LinkedList lList = new LinkedList();
		lList.insert(lList, 4);
		lList.insert(lList, 5);
		lList.insert(lList, 6);
		lList.insert(lList, 7);
		lList.printLinkedList(lList);

	}

}

class LinkedNode {

	int data;
	LinkedNode next;

	public LinkedNode(int value) {
		this.data = value;
	}

}
