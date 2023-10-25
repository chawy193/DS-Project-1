package ds.vegetable;

/**
 * Custom exception for invalid vegetable weight. 
 * Use super to initialize exception's error message.
 */
@SuppressWarnings("serial")
public class InvalidVegetableRipenessException extends RuntimeException {
	public InvalidVegetableRipenessException(String message) {
        super(message);
    }
}
