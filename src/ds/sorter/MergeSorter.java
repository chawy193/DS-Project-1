package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		if (input.size() <= 1) {
			return input;
		}
		
		int mid = input.size() / 2;
		List<E> left = input.subList(0, mid);
		List<E> right = input.subList(mid, input.size());
		
		left = sort(left);
		right = sort(right);
		
		return merge(left, right);
	}
	
	private List<E> merge(List<E> left, List<E> right) {
		List<E> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		
		while (i < left.size() && j < right.size()) {
			if (left.get(i).compareTo(right.get(j)) <= 0) {
				result.add(left.get(i));
				i++;
			} else {
				result.add(right.get(j));
				j++;
			}
		}
		
		while (i < left.size()) {
			result.add(left.get(i));
			i++;
		}
		
		while (j < right.size()) {
			result.add(right.get(j));
			j++;
		}
		
		return result;
	}
}
