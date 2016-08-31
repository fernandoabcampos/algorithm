package cracking.extra;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BigONotation {
	private int[] array;
	private int itemsInArray = 0;
	private int arraySize;
	private Instant init;

	public BigONotation(int arraySize) {
		super();
		this.arraySize = arraySize;
		array = new int[arraySize];
	}

	public static void main(String[] args) {
		BigONotation testAlgo = new BigONotation(100000);
		testAlgo.generateRandomArray();

		BigONotation testAlgo2 = new BigONotation(200000);
		testAlgo2.generateRandomArray();

		BigONotation testAlgo3 = new BigONotation(300000);
		testAlgo3.generateRandomArray();

		BigONotation testAlgo4 = new BigONotation(400000);
		testAlgo4.generateRandomArray();

		testAlgo4.linearSearchForValue(20);
		testAlgo3.linearSearchForValue(20);
		testAlgo2.linearSearchForValue(20);
		testAlgo.linearSearchForValue(20);

		testAlgo.bubbleSort();
		testAlgo2.bubbleSort();
		testAlgo3.bubbleSort();
		testAlgo4.bubbleSort();

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
		int count = 0;

		String indexsWithValue = "";

		init = Instant.now();
		for (int i = 0; i < arraySize; i++) {
			if (array[i] == value) {
				valueInArray = true;
				indexsWithValue += ", array[" + i + "] = " + array[i];
				count++;
			}
		}

		System.out.println(String.format("Found: %b - %d times", valueInArray, count));
		System.out.println("Linear search: "
				+ (indexsWithValue.length() > 0 ? indexsWithValue.substring(1, indexsWithValue.length()) : ""));
		System.out.println("Linear search took: " + ChronoUnit.MILLIS.between(init, Instant.now()) + " ms.");

	}

	/*
	 * O(N^2) - Order of square N - the times to complete will be proportional
	 * to two squares of the amount of data A typical scenario is a bubble sort
	 * operation where we have nested operations
	 */
	public void bubbleSort() {
		init = Instant.now();
		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swapValues(j, j + 1);
				}
			}

		}
		System.out.println("Bubble sort took: " + ChronoUnit.MILLIS.between(init, Instant.now()) + " ms.");
	}

	private void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			array[i] = (int) (Math.random() * 1000) + 10;
		}

		itemsInArray = arraySize - 1;
	}

	private void swapValues(int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}

}
