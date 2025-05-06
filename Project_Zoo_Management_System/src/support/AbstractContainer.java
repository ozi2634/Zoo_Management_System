package support;

public abstract class AbstractContainer implements Container {
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Container)) {
			return false;
		}
		Container other = (Container) o; // Cast zu Container
		if (this.size() != other.size()) {
			return false;
		}
		for (int i = 0; i < this.size(); i++) {
			Object thisElement = this.get(i);
			Object otherElement = other.get(i);
			if (thisElement == null) {
				if (otherElement != null) {
					return false;
				}
			} else {
				if (!thisElement.equals(otherElement)) {
					return false;
				}
			}
		}
		return true;
	}

	public String toString() {
		String x = new String();
		System.out.print("[");
		for (int i = 0; i < size(); i++) {
			if (i < size() + 1) {
				System.out.print(get(i) + ",");
			} else {
				System.out.print(get(i));
			}
		}

		System.out.println("]");
		return x.toString();

	}
}