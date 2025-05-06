package core;

import core.Herbivore;

public class Panda implements Herbivore{

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHungry() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCarnivore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHerbivore() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isOmnivore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eatPlant() {
		// TODO Auto-generated method stub
	}

}
