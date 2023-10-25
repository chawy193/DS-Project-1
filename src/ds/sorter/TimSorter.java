package ds.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Scenario: "You have been contacted by your librarian friend Sarah who works at a library plagued by mischief makers. 
 * These mischief makers are coming into the library once a week and mixing up all the books so that Sarah has to work 
 * late to fix the mess. This means Sarah gets less sleep than she needs and ends up being grumpy the next day. Sarah 
 * (and her colleagues) wants to know if you know of any approaches (algorithms) that she can use to minimise the amount 
 * of time that she has to spend sorting the library books so that she can try to get a good night’s sleep."
 * 
 * I recommend using TimSort as the sorting algorithm for sorting the library books.
 * Stable: Relative order of equal elements is preserved. Important for library books, since same author or title should
 * remain its order.
 * Adaptive: If some library books already in order, TimSort can take advantage of the partial order.
 * Efficiency: TimSort is efficient with data that is already in some order, which is similar to the scenario in a library.
 * TimSort is a reliable choice for library books due to its adaptability and performance with real-world data, as well 
 * as its stable sorting properties, which are essential for maintaining the relative order of books with the same attributes. 
 * It should help Sarah and her colleagues minimize the time spent sorting books and get a good night's sleep.
 */
public class TimSorter<E extends Comparable<E>> implements Sorter<E> {

	private static final int MIN_MERGE = 32;
	
	@Override
	public List<E> sort(List<E> input) {
		
		// Convert list to an array for sorting.
		@SuppressWarnings("unchecked")
		E[] arr = input.toArray((E[]) new Comparable[input.size()]);
		
		int n = arr.length;
		
		// Sort individual sub arrays of size MIN_MERGE.
		for (int i = 0; i < n; i += MIN_MERGE) {
			int from = i;
			int to = Math.min(i + MIN_MERGE, n);
			Arrays.sort(arr, from, to);
		}
		
		// Merge the sorted sub arrays using TimSort.
		int minRun = MIN_MERGE;
		while (minRun < n) {
			for (int i = 0; i < n; i += minRun << 1) {
				int from = i;
				int mid = Math.min(i + minRun, n);
				int to = Math.min(i + (minRun << 1), n);
				if (mid < to) {
					merge(arr, from, mid, to);
				}
			}
			minRun <<= 1;
		}
		
		// Convert array back to list.
		List<E> result = new ArrayList<>(Arrays.asList(arr));
		return result;
   	}
	
	private void merge(E[] arr, int from, int mid, int to) {
		
		// Setup the range of elements to compare.
		int len1 = mid - from;
		int len2 = to - mid;
		E[] left = Arrays.copyOfRange(arr, from, mid);
		E[] right = Arrays.copyOfRange(arr, mid, to);
		int i = 0;
		int j = 0;
		int k = from;
		
		// Loop through range of sub arrays.
		// Using compareTo method to compare elements in sub arrays.
		// Depend compare outcome to add element from left sub array or
		// right sub array to array.
		while (i < len1 && j < len2) {
			if (left[i].compareTo(right[j]) <= 0) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		
		// If there are elements from left hand array not yet added, 
		// when comparing to elements from right hand array, will be added
		// to the array now.
		while (i < len1) {
			arr[k++] = left[i++];
		}
		
		// If there are elements from right hand array not yet added, 
		// when comparing to elements from left hand array, will be added
		// to the array now.
		while (j < len2) {
			arr[k++] = right[j++];
		}
	}
}
