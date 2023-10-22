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
		return Double.compare(vegetable.weight, weight) == 0 && 
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
	
	@Override
    public int compareTo(Vegetable other) {
		
		// Capsicum is greater than other types
        if (this.type == TYPE.CAPSICUM && other.type != TYPE.CAPSICUM) {
            return 1; 
        
		// Other types are less than capsicum
		} else if (this.type != TYPE.CAPSICUM && other.type == TYPE.CAPSICUM) {
            return -1; 
		
		// Both types are capsicum
		} else if (this.type == TYPE.CAPSICUM && other.type == TYPE.CAPSICUM) {
			
			// Compare capsicum weight
			int weightComparison = Double.compare(this.weight, other.weight);
			if (weightComparison != 0) {
				
				// Compare capsicum ripeness if weight difference is within 0.05
				double thisWeight = this.weight;
				double otherWeight = other.weight;
				double weightDiff = thisWeight - otherWeight;
				if (-0.05 <= weightDiff && weightDiff <= 0.05) {
					return Double.compare(this.ripeness, other.ripeness);
				} else {
					return weightComparison;
				}
			} else {
				return Double.compare(this.ripeness, other.ripeness);
			}
		
		// Other types, tomato, lettuce and onion
        } else if (this.type != TYPE.CAPSICUM && other.type != TYPE.CAPSICUM) {
            
			// Tomato or lettuce is greater than onion
			if (this.type != TYPE.ONION && other.type == TYPE.ONION) {
				return 1;
			
			// Onion is less than tomato or lettuce
			} else if (this.type == TYPE.ONION && other.type != TYPE.ONION) {
				return -1;
			
			// Compare weight between tomato and lettuce, or onion and onion
			} else {
				int weightComparison = Double.compare(this.weight, other.weight);
				if (weightComparison != 0) {
					
					// Compare vegetable ripeness if weight difference is within 0.05
					double thisWeight = this.weight;
					double otherWeight = other.weight;
					double weightDiff = thisWeight - otherWeight;
					if (-0.05 <= weightDiff && weightDiff <= 0.05) {
						return Double.compare(this.ripeness, other.ripeness);
					} else {
						return weightComparison;
					}
				} else {
					return Double.compare(this.ripeness, other.ripeness);
				}
			}
            
        }
		
		// Same weight and ripeness if none of the conditions are met
        return 0; 
    }
	
}


