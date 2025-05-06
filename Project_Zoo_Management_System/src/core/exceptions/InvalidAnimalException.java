package core.exceptions;

public class InvalidAnimalException extends Exception {

	public InvalidAnimalException() {
		super("Dieses Tier passt nicht hier!");
	}
}
