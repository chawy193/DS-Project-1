package ds.sorter;

import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		
		// Grab list size.
		int n = input.size();
		
		// Loop through list.
		// Grab first element's position in list to start.
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			
			// Grab next element's position in list.
			// Compare with first element, if return is less than 0,
			// then next element's position will take over first element's position in list.
			for (int j = i + 1; j < n; j++) {
				if (input.get(j).compareTo(input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			
			// Temporary store list's first element, as it may no longer first element.
			// list to write first element's position with the outcome of what minIndex is now.
			// Then overwrite minIndex with the temporary element stored.
			E temp = input.get(i);
			input.set(i, input.get(minIndex));
			input.set(minIndex, temp);
		}
		
		return input;
   	}
}
