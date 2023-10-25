package ds.vegetable;

/**
 * Custom exception for invalid vegetable weight. 
 * Use super to initialize exception's error message.
 */
@SuppressWarnings("serial")
public class InvalidVegetableWeightException extends RuntimeException {
	public InvalidVegetableWeightException(String message) {
        super(message);
    }
}
