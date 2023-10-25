package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		
		// Check if list has only 1 or less element, then return list as no sort required.
		if (input.size() <= 1) {
			return input;
		}
		
		// Grab middle index of the list.
		// Split list into left hand side list and right hand side list.
		int mid = input.size() / 2;
		List<E> left = input.subList(0, mid);
		List<E> right = input.subList(mid, input.size());
		
		// Sort left hand side list and right hand side list.
		left = sort(left);
		right = sort(right);
		
		// Call merge function to combine left hand list and right hand list.
		// Return sorted list.
		return merge(left, right);
	}
	
	private List<E> merge(List<E> left, List<E> right) {
		
		// Setup new temporary array list.
		List<E> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		
		// Add elements from left hand side list and right hand side list.
		// Using compareTo method to determine which element add first.
		while (i < left.size() && j < right.size()) {
			if (left.get(i).compareTo(right.get(j)) <= 0) {
				result.add(left.get(i));
				i++;
			} else {
				result.add(right.get(j));
				j++;
			}
		}
		
		// If there are elements from left hand side list not yet added, 
		// when comparing to elements from right side list, will be added
		// to the list now.
		while (i < left.size()) {
			result.add(left.get(i));
			i++;
		}
		
		// If there are elements from right hand side list not yet added, 
		// when comparing to elements from left side list, will be added
		// to the list now.
		while (j < right.size()) {
			result.add(right.get(j));
			j++;
		}
		
		return result;
	}
}
