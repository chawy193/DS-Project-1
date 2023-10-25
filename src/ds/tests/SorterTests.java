package ds.tests;

import static org.junit.jupiter.api.Assertions.*;

import ds.vegetable.Vegetable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import ds.sorter.*;

class SelectionSorterTest {

	private List<Vegetable> vegetableList;
	
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    	
    	// Initialize the vegetable list to test CustomSorting.
        vegetableList = new ArrayList<>();
        
        // Add Vegetable objects to the list
        vegetableList.add(new Vegetable(Vegetable.TYPE.TOMATO, 0.5, 0.6));
        vegetableList.add(new Vegetable(Vegetable.TYPE.ONION, 0.3, 0.8));
        vegetableList.add(new Vegetable(Vegetable.TYPE.CAPSICUM, 0.2, 0.9));
        vegetableList.add(new Vegetable(Vegetable.TYPE.LETTUCE, 0.4, 0.7));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    static Stream<Sorter<Integer>> IntegerSorters() {
    	return Stream.of(new SelectionSorter<Integer>(), new MergeSorter<Integer>(), new TimSorter<Integer>());
    }
    
    @ParameterizedTest
    @MethodSource("IntegerSorters")
    void testSort(Sorter<Integer> sorter) {
    	
    	int min = 0;
    	int max = 15;
    	
    	// The input is a reversed list: biggest to smallest. 
        ArrayList<Integer> input = new ArrayList<Integer>(IntStream
                .range(min, max)
                .map(i -> max - i - 1) // Reverse the stream
                .boxed()
                .toList()
        );

        // The expected output is an in-order list: smallest to biggest. 
        ArrayList<Integer> expected = new ArrayList<Integer>(IntStream
                .range(min, max)
                .boxed()
                .toList()
        );
        
        Collection<?> sorted = sorter.sort(input);
        
        System.out.print("Sorted array: ");
        Stream.of(sorted).forEach(System.out::println);
        
        System.out.print("Expected output: ");
        Stream.of(expected).forEach(System.out::println);
        

        assertArrayEquals(sorted.toArray(), expected.toArray(), 
        		"Reversed integer list is not sorted correctly using " + sorter.getClass());
    }

    @ParameterizedTest
    @MethodSource("IntegerSorters")
    void testReversedSort(Sorter<Integer> sorter) {
      	int min = 0;
    	int max = 15;
    	
    	// The input is an in-order list: smallest to biggest. 
        ArrayList<Integer> input = new ArrayList<Integer>(IntStream
                .range(min, max)
                .boxed()
                .toList()
        );
        
    	// The expected output is an in-order list: smallest to biggest.  
        ArrayList<Integer> expected = new ArrayList<Integer>(IntStream
                .range(min, max)
                .boxed()
                .toList()
        );

        Collection<?> sorted = sorter.sort(input);

        // Convert the output to arrays for comparison
        assertArrayEquals(sorted.toArray(), expected.toArray());
    }
    
    @Test
    void testSortByType() {
    	List<Vegetable> sortedList = CustomSorting.sortByType(vegetableList);
    	
    	// Check if the sorted list is not null.
    	assertNotNull(sortedList);
    	
    	// Check if the list is sorted by type in the expected order.
    	assertEquals(vegetableList.get(0).getType(), sortedList.get(0).getType());
    	assertEquals(vegetableList.get(1).getType(), sortedList.get(1).getType());
    	assertEquals(vegetableList.get(2).getType(), sortedList.get(2).getType());
    	assertEquals(vegetableList.get(3).getType(), sortedList.get(3).getType());
    }
    
    @Test
    void testSortByTypeEmptyList() {
    	
    	// Test sorting an empty list.
    	List<Vegetable> emptyList = new ArrayList<>();
    	List<Vegetable> sortedList = CustomSorting.sortByType(emptyList);
    	
    	// Check if the sorted list is empty.
    	assertTrue(sortedList.isEmpty());
    }
    
    @Test
    void testSortByRipeness() {
    	CustomSorting.sortByRipeness(vegetableList);
    	
    	// Check if the list is sorted by ripeness in the expected order.
    	assertEquals(0.9, vegetableList.get(0).getRipeness());
    	assertEquals(0.8, vegetableList.get(1).getRipeness());
    	assertEquals(0.7, vegetableList.get(2).getRipeness());
    	assertEquals(0.6, vegetableList.get(3).getRipeness());
    }
    
    @Test
    void testSortByRipenessEmptyList() {
    	List<Vegetable> emptyList = new ArrayList<>();
    	CustomSorting.sortByRipeness(emptyList);
    	
    	// Check if the sorted list is empty.
    	assertTrue(emptyList.isEmpty());
    }
}
