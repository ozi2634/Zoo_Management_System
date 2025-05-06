package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import core.Lion;
import core.Panda;
import core.Tiger;
import core.ZooHabitat;
import core.Panda;
import core.exceptions.HabitatFullException;
import core.exceptions.InvalidAnimalException;

class TestZooHabitat {

	@Test
	void testAddAnimal() throws InvalidAnimalException, HabitatFullException {
		ZooHabitat zoo = new ZooHabitat(3);
		Lion lion = new Lion();
		Panda panda = new Panda();
		Tiger tiger = new Tiger();

		zoo.addAnimal(lion);

		assertThrows(InvalidAnimalException.class, () -> zoo.addAnimal(panda));// verify if the exception exist
		zoo.addAnimal(tiger);

	}

	@Test
	void testanimals() throws InvalidAnimalException, HabitatFullException {
		ZooHabitat zoo = new ZooHabitat(3);
		Lion lion = new Lion();
		Tiger tiger = new Tiger();

		zoo.addAnimal(lion);
		zoo.addAnimal(tiger);

		assertEquals(2, zoo.animals());
	}

	@Test
	void testgetcapacity() throws InvalidAnimalException, HabitatFullException {
		ZooHabitat zoo = new ZooHabitat(3);
		Lion lion = new Lion();

		zoo.addAnimal(lion);

		assertEquals(2, zoo.getCapacity());
	}

}
