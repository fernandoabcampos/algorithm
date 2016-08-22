package cracking.extra;

import java.util.Arrays;

public class ExtraBinarySearch {
	static int binarySearch(int target, int[] array){
		int high = array.length - 1;
		int low = 0;
		System.out.println(Arrays.toString(array));
		
		while ( high >= low){
			int middleOfSearch = ( low + high ) / 2;
			System.out.println(String.format("Element[%d]: %d ~ %d - %b", middleOfSearch, array[middleOfSearch], target, array[middleOfSearch] == target));
			
			if(array[middleOfSearch] == target){
				return middleOfSearch;
			}
			else{
				if(array[middleOfSearch] < target){
					low = middleOfSearch + 1;
					System.out.println(String.format("Lower - now low value is: %d", low));
				}
				else{
					high = middleOfSearch - 1;
					System.out.println(String.format("Higher - now high value is: %d", high));
				}
			
			}
		}
		
		return -1;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 3, 4, 6, 7, 8, 10, 13, 14};
		
		System.out.println("Result for 4 found at " + binarySearch(4, array)+"\n");
		System.out.println("Result for 3 found at " + binarySearch(3, array)+"\n");
		System.out.println("Result for 1 found at " + binarySearch(1, array)+"\n");
		System.out.println("Result for 14 found at " + binarySearch(14, array)+"\n");
		System.out.println("Result for 2 found at " + binarySearch(2, array)+"\n");
		
	}

	public int solution(int N){
		return N;
	}
}
