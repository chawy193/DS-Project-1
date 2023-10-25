package ds.sorter;

import java.util.Collections;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		
		// Using Java Collections sort method.
		Collections.sort(input);
		return input;
   	}
}
