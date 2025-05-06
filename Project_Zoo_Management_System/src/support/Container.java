package support;

public interface Container {
	/*
	 *
	 * @param o Element to add to the container
	 * 
	 * @return true if this container changed as a result of the call
	 */
	boolean add(Object o);

	/*
	 * 
	 * @param i Index of the Element
	 * 
	 * @return
	 */
	Object get(int i);

	/*
	 * Gets the number of elements in the container
	 * 
	 * @return Number of elements in the container
	 */
	default int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * Removes the element from the container if it is contained in the container.
	 * This will only remove the first instance of the object if the object is
	 * contained more than once in the container.
	 * 
	 * @param o Element to remove from the container
	 * 
	 * @return true if the container changed because of the operation, false
	 * otherwise
	 */
	boolean remove(Object o);

	/*
	 * Checks if two containers are equal. They are considered equal if all elements
	 * contained in the container are equal. This means both containers must have
	 * the same number of elements and the equal elements must be in the same order.
	 * 
	 * @param o Other container
	 * 
	 * @return
	 */
	boolean equals(Object o);

	/**
	 * Removes all elements from the container
	 */
	default void clear() {
		while (!isEmpty()) {
			// for (int i=0;i<size();i++) {
			remove(get(0));
			// }
		}
	}

	/*
	 * Checks if the object is contained in the container. The container uses the
	 * equals()-Method to check if the object is in the container.
	 * 
	 * @param o Object to search for in the container
	 * 
	 * @return true if the object is in the container, false otherwise
	 */
	default boolean contains(Object o) {
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Converts the container content to an array an returns the array
	 * 
	 * @return Array containing all elements in the container
	 */

	default Object[] toArray() {
		Object[] arr = new Object[size()];
		for (int i = 0; i < size(); i++) {
			arr[i] = get(i);
		}
		return arr;
	}

	/*
	 * Checks if the container contains any elements
	 * 
	 * @return true if container is empty, false otherwise
	 */
	default boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
}