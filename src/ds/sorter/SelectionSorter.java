package ds.sorter;

import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		int n = input.size();
		
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < n; j++) {
				if (input.get(j).compareTo(input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			
			E temp = input.get(i);
			input.set(i, input.get(minIndex));
			input.set(minIndex, temp);
		}
		
		return input;
   	}
}
