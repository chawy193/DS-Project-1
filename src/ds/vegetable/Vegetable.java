package ds.vegetable;

import java.util.Objects;

enum Type {
	CAPSICUM,
	TOMATO,
	LETTUCE,
	ONION
}

public class Vegetable {
	
	private Type type;
	private double weight;
	private double ripeness;
	
	/**
	 * Setup vegetable object attributes.
	 * @result Type, weight, ripeness, 
	 *         with restrictions e.g. weight cannot be negative
	 *         and ripeness must be between 0 and 1.
	 */

	public Vegetable(Type type, double weight, double ripeness) {
		
		this.type = type;
		this.weight = weight;
		this.ripeness = ripeness;
		
	}
	
	public Type getType() {
		return type;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getRipeness() {
		return ripeness;
	}
	
	@Override
	public boolean equals() {
		return false;
	}
	
	@Override
	public int hashcode() {
		return Objects.hash(type, weight, ripeness);
	}
	
	@Override
	public String toString() {
		return "Vegetable {" + 
				"type = " + type + 
				", weight = " + weight + 
				"kg, ripeness = " + ripeness + 
				'}';
	}
	
	
}
