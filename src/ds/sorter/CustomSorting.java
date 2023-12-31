package ds.sorter;

import java.util.Comparator;
import java.util.List;
import ds.vegetable.Vegetable;

public class CustomSorting {
	
	/**
	 * This method must sort the vegetable alphabetically by their type.
	 * The weight and ripeness of a vegetable should not be considered. 
	 *  
	 * @param list The list to sort. 
	 * @return A sorted list. 
	 */
	public static List<Vegetable> sortByType(List<Vegetable> list) {
		list.sort(new Comparator<Vegetable>() {
			// Implement your custom compare method here. 
			
			@Override
			// Implement custom compare method sorting by type.
			public int compare(Vegetable veg1, Vegetable veg2) {
				
				// Setup alphabetical order of type.
				String[] typeOrder = {"CAPSICUM", "LETTUCE", "ONION", "TOMATO"};
				int index1 = -1;
				int index2 = -1;
				
				// Grab vegetable type from the list and check it's position in the alphabetical order.
				for (int i = 0; i < typeOrder.length; i++) {
					if (veg1.getType() == Vegetable.TYPE.valueOf(typeOrder[i])) {
						index1 = i;
					}
					
					if (veg2.getType() == Vegetable.TYPE.valueOf(typeOrder[i])) {
						index2 = i;
					}
				}
				
				// Compare the vegetable's position and return -1, 0, 1 to sort alphabetically.
				return Integer.compare(index1, index2);
			}
	    });
		return list;
	}
	
	/**
	 * This method must sort the vegetable by their ripeness value, from 100% ripe to 0% ripe. 
	 * The type and weight of the vegetable should not be considered. 
	 * 
	 * @param list The vegetable to sort
	 * @return	   A sorted list. 
	 */
	public static List<Vegetable> sortByRipeness(List<Vegetable> list) {
		list.sort(new Comparator<Vegetable>() {
			// Implement your custom compare method here. 
			
			@Override
			public int compare(Vegetable veg1, Vegetable veg2) {
				
				// Compare vegetable's ripeness return -1, 0, 1 to sort in descending order.
				return Double.compare(veg2.getRipeness(), veg1.getRipeness());
			}
		});
		return list;
	}
}
