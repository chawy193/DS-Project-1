package ds.vegetable;

import java.util.Objects;

public class Vegetable {
	
	private TYPE type;
	private double weight;
	private double ripeness;
	
	public enum TYPE {
		CAPSICUM,
		TOMATO,
		LETTUCE,
		ONION
	}
	
	/**
	 * Setup vegetable object attributes.
	 * @result Type, weight, ripeness, 
	 *         with restrictions e.g. weight cannot be negative
	 *         and ripeness must be between 0 and 1.
	 */

	public Vegetable(TYPE type, double weight, double ripeness) {
		
		this.type = type;
		this.weight = weight;
		this.ripeness = ripeness;
		
		if (weight < 0) {
			throw new InvalidVegetableWeightException("Vegetable weight is incorrect");
		}
		
		if (ripeness < 0 || ripeness > 1) {
			throw new InvalidVegetableRipenessException("Vegetable ripeness is incorect");
		}
		
	}
	
	public TYPE getType() {
		return type;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getRipeness() {
		return ripeness;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Vegetable vegetable = (Vegetable) o;
		return Double.compare(vegetable.weight, weight) < 0.05 && 
				Double.compare(vegetable.ripeness, ripeness) == 0 && 
				type == vegetable.type;
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
				"%}";
	}
	
}


