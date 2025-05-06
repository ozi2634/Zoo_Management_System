package core;

import java.util.function.BooleanSupplier;

import support.AbstractContainer;

public class DoubleLinkedList extends AbstractContainer {

	private static class Node {
		Object data;
		Node next;
		Node prev;

		// data: Speichert das Element im Knoten.
		// next: Referenz auf das nächste Element in der Liste.
		// prev: Referenz auf das vorherige Element in der Liste.

		Node(Object data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	// Initialisiert head und tail mit neuen Knoten, die null als Daten enthalten.
	// Setzt size auf 0.
	public DoubleLinkedList() {
		head = new Node(null);
		tail = new Node(null);
		size = 0;
	}

	public void pushFront(Object o) {
		Node newnode = new Node(o);
		if (head == null) {
			head = tail = newnode;
		} else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;
	}

	public Object popBack() {
		if (tail == null) {
			return ("list is empty");
		}
		Object data = tail.data;
		tail = tail.prev;
		if (tail.next == null) {
			head = null;
		} else {
			tail.next = null;
		}
		size--;

		return data;
	}

	public Object getFront() {
		if (head == null) {
			return ("List is empty");
		}
		return head.data;
	}

	// Aufgabe 3
	// Die Implementierung der Methode get() von Container soll eine
	// ArrayIndexOutOfBoundsException werfen, wenn ein invalider Index übergeben
	// wird
	public Object get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			return null;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public int size() {
		return size;
	}

	public boolean add(Object o) {
		pushFront(o);
		return false;
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public boolean remove(Object o) {
		Node current = head;
		while (current != null) {
			if (current.data.equals(o)) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}
				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}
				size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {

		// Erstellt eine Instanz der DoubleLinkedList.
		DoubleLinkedList l = new DoubleLinkedList();
		System.out.println("isEmpty(): " + l.isEmpty());
		l.add("Test1");
		l.add("Test2");
		l.add("Test3");
		System.out.println("Size: " + l.size());
		System.out.println("get(1): " + l.get(1));
		System.out.println("remove(\"Test2\"): " + l.remove("Test2"));
		System.out.println("Size: " + l.size());
		System.out.println("isEmpty(): " + l.isEmpty());
	}

}