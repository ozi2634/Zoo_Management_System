package support;

public class Vector extends AbstractContainer {
	private Object[] y;
	private int size;
	private static int DEFAULT = 10;

	public Vector() {
		this(DEFAULT);
	}

	public Vector(int startLength) {
		this.y = new Object[startLength];
		// this.size = startLength;
	}

	@Override
	public boolean add(Object o) {
		if (size == y.length) {
			Object[] arr = new Object[y.length + 1];

			for (int i = 0; i < size; i++) {
				arr[i] = y[i];
			}
			y = arr;
		}
		y[size] = o;
		size++;
		return true;
	}

	@Override
	public Object get(int i) {
		if (i >= size) {
			System.out.println("i is not available");
		} else
			return y[i];
		return null;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < y.length; i++) {
			if (y[i].equals(o)) {
				for (int j = i; j < size - 1; j++) {
					y[j] = y[j + 1];
				}
				y[size - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

}