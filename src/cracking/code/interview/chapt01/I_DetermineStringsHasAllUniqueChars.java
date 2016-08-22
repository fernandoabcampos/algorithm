package cracking.code.interview.chapt01;

import java.util.HashSet;
import java.util.Set;

public class I_DetermineStringsHasAllUniqueChars {
	
	public static boolean hasOnlyUniqueChars(String value){
		Set<Character> unique = new HashSet<>();
		
		for(Character currentChar : value.toCharArray()){
			if(unique.contains(currentChar)){
				System.out.println("Set of chars:  " + unique);
				return false;
			}
			
			unique.add(currentChar);
		}
		
		System.out.println("Set of chars:  " + unique);
		
		System.out.println("REVERSED: "+ new StringBuilder(value).reverse().toString());
		return true;
		
	}
	
	
	
	public static void main(String[] args) {
		String value = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("Result of "+value+" is: " + hasOnlyUniqueChars(value));
		
		value = "abcdefghijklmnopqrstuvwxyza";
		System.out.println("Result of "+value+" is: " + hasOnlyUniqueChars(value));
		
		value = "abcdefgGhijklmnopqrstuvwxyz";
		System.out.println("Result of "+value+" is: " + hasOnlyUniqueChars(value));
		
	}

}
