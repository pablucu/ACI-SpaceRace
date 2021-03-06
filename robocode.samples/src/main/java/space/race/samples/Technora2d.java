package space.race.samples;

import robocode.ScannedRobotEvent;
import space.spaceship.AbstractSpaceship;
import space.spaceship.coolingsystem.Fan;
import space.spaceship.fuel.Coal;
import space.spaceship.fuel.Hydrogen;
import space.spaceship.fuel.Petrol;
import space.spaceship.model.SpaceEngine;

/**
 * This is a spaceship cooling system example. Technora2c uses a mix of fuels
 * and a fan as a cooling system.
 * 
 * @author Pablo Rodriguez (original)
 */
public class Technora2d extends AbstractSpaceship {

	// Constructor
	public Technora2d() {
		super();

		// Set the type of Spaceship (Atlantis, Buran, Challenger)
		setAsBuranModel();

		// Set the cooling System
		setCoolingSystem(new Fan());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void runACI() {

		// Main loop
		while (true) {

			if (getTemperature() < SpaceEngine.overheatTemperature) {
				accelerate();
			} else { // OVERHEAT
				// Stop 10 turns to cool the system
				for (int i = 1; i <= 10; i++) {
					System.out.println("Cooling " + i + ": "
							+ getTemperature());
					stop();
				}
				System.out.println("Cooled: " + getTemperature());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFuel() {
		addFuel(Coal.name, 3950);
		addFuel(Petrol.name, 1000);
		addFuel(Hydrogen.name, 50);
	}

	@Override
	public void onScannedAsteroid(ScannedRobotEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScannedSpaceship(ScannedRobotEvent event) {
		// TODO Auto-generated method stub

	}

}