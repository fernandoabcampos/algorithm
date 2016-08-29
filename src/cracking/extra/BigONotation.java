package cracking.extra;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BigONotation {
	private int[] array;
	private int itemsInArray = 0;

	public static void main(String[] args) {

	}

	/*
	 * O(1) - Order of 1 Execute in the same amount of time regardless the
	 * amount of data (no matter how big the array is)
	 */
	public void addItemToAnArray(int newItem) {
		array[itemsInArray++] = newItem;
	}

	/*
	 * O(N) - Order of N Means that the time to complete this algorithm will
	 * grow directly in proportion of the amount of data
	 */
	public void linearSearchForValue(int value) {
		boolean valueInArray = false;

		String indexsWithValue = "";

		Instant init = Instant.now();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				valueInArray = true;
				indexsWithValue += i + " ";
			}
		}
		
		System.out.println(String.format("Found: %b", valueInArray));
		System.out.println("Linear search took: "+ ChronoUnit.MILLIS.between(init, Instant.now()) + " ms.");
		
		//TODO: Finish later
	}

}
