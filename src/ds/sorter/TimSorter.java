package ds.sorter;

import java.util.Collections;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		Collections.sort(input);
		return input;
   	}
}
