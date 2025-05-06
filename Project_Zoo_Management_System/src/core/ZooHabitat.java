package core;

import core.exceptions.HabitatFullException;
import core.exceptions.InvalidAnimalException;

// Wir wollen uns hier auf die Klasse ZooHabitat beschränken.
public class ZooHabitat {

//	animals: Eine doppelt verkettete Liste (DoubleLinkedList), die die Tiere im Habitat speichert.
//	maxCapacity: Die maximale Anzahl von Tieren, die das Habitat aufnehmen kann.
//	size: Die aktuelle Anzahl der Tiere im Habitat.
//	onlyforcarnivore: Ein Flag, das anzeigt, ob das Habitat nur für Fleischfresser (Carnivores) bestimmt ist.
	private DoubleLinkedList animals;
	private int maxCapacity;
	private int size;
	public boolean onlyforcarnivore = true;

	public ZooHabitat(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.animals = new DoubleLinkedList();
	}

	public void addAnimal(Animal a) throws HabitatFullException, InvalidAnimalException {
		if (getCapacity() == 0) {
			throw new HabitatFullException();
		}
		if (onlyforcarnivore != a.isCarnivore()) {
			throw new InvalidAnimalException();

		}

		animals.add(a);
		size++;
	}

	public int animals() {
		return size;

	}

	public int getCapacity() {
		return maxCapacity - animals();
	}

}