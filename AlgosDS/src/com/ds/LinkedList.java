package com.ds;

/**
 * LinkedList implementation
 * 
 * https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * 
 * @author Anto
 *
 */
public class LinkedList {

	Node head;
	int size = 0;

	class Node {

		int data;
		Node next;

		public Node(int value) {
			this.data = value;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size = size + 1;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size = size + 1;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			System.out.println("Inserted value at head: " + data);
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			System.out.println("Inserted " + last.next.data + " After " + last.data);
		}
		size = size + 1;
	}  
 
	public void insert(int index, int val) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		System.out.println("Inserting at " + index);
		Node newNode = new Node(val);
		if (index == 0) {
			head = newNode;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node nodeNextToNewNode = current.next;
			current.next = newNode;
			newNode.next = nodeNextToNewNode;
		}
		size = size + 1;
	}

	public boolean deleteFirst() {
		if (head == null) {
			return false;
		} else {
			Node current = head.next;
			head = current;
			size = size - 1;
			return true;
		}
	}

	public boolean deleteAt(int index) {
		if (head == null || index < 0 || index > size) {
			return false;
		}
		if (index == 0) {
			deleteFirst();
		} else {
			Node current = head;
			Node previous = null;
			for (int i = 0; i < index; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			size = size - 1;
		}
		return true;
	}

	public boolean deleteLast() {
		if (head == null) {
			return false;
		} else {
			Node current = head;
			Node nextNode = head.next;
			while (current != null && nextNode.next != null) {
				current = current.next;
				nextNode = nextNode.next;
			}
			size = size - 1;
			current.next = null;
			return true;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void printLinkedList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public void reverseLinkedList() {
		System.out.println(" === Before reversal ==== ");
		printLinkedList();
		Node current = head;
		Node next = null;
		Node previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous; 
		printLinkedList(); 
	}

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		System.out.println(lList.size() + " " + lList.isEmpty());
		lList.insert(4);
		System.out.println(lList.size() + " " + lList.isEmpty());
		lList.insert(5);
		lList.insert(6);
		lList.insert(7);
		lList.printLinkedList();
		System.out.println(lList.deleteLast());
		System.out.println(lList.deleteLast());
		lList.printLinkedList();
		lList.insert(8);
		lList.insert(9);
		lList.insert(10);
		lList.printLinkedList();
		// lList.insert(2, 6);
		System.out.println("Size" + lList.size);
		lList.insert(lList.size, 11);
		lList.printLinkedList();
		lList.deleteAt(1);
		lList.deleteAt(4);
		lList.deleteAt(0);
		lList.printLinkedList();
		lList.reverseLinkedList();
	}

}
