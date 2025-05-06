package support;

public class List extends AbstractContainer {
	private static class Node {
		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private int size;

	public List() {
		head = new Node(null);
		size = 0;

	}

	public void pushFront(Object o) {
		Node newnode = new Node(o);
		newnode.next = head;
		head = newnode;
		size();

	}

	public Object popBack() {
		if (head == null) {
			return ("list is empty");
		}
		if (head.next == null) {
			Object data = head.data;
			head = null;
			size--;
			return data;
		}
		Node prev = head;
		while (prev.next.next != null) {
			prev = prev.next;
		}
		Object data = prev.next.data;
		prev.next = null;
		size--;
		return data;
	}

	public Object getFront() {
		if (head == null) {
			return ("List is empty");
		}
		return head.data;
	}

	public Object get(int index) {
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
		int size = 0;
		Node iter = head.next;
		while (iter != null) {
			size++;
			iter = iter.next;
		}
		return size;
	}

	@Override
	public boolean add(Object o) {
		pushFront(o);
		return false;
	}

	@Override
	public boolean remove(Object o) {
		Node prev = head;
		Node iter = head.next;
		if (head.data == o) {
			head = head.next;
			return true;
		}
		while (iter != null) {
			if (iter.data.equals(o)) {
				prev.next = iter.next;
				iter = null;
				return true;
			}
			prev = iter;
			iter = iter.next;
		}
		return false;
	}

	public static void main(String[] args) {
		List l = new List();
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