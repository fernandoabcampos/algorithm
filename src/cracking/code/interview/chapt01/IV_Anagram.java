package cracking.code.interview.chapt01;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class IV_Anagram {

	/*
	 * Solution considering that each letter must obligatory be juxtaposed in a
	 * specific position as it is in the primary one.
	 */
	public static boolean isAnagramHowIWouldDoDayToDay(String value) {

		System.out.println(String.format("Original: %s", value));
		String reversed = new StringBuilder(value).reverse().toString();
		System.out.println(String.format("Reversed: %s", reversed));
		return value.equals(reversed);
	}

	/*
	 * Solution by the book, count numbers of each chars.
	 */
	public static boolean anagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		int[] letters = new int[256];

		int num_unique_chars = 0;
		int num_completed_t = 0;

		char[] s_array = s.toCharArray();

		for (char c : s_array) { // count number of each char in s.

			if (letters[c] == 0)
				++num_unique_chars;

			++letters[c];

		}

		for (int i = 0; i < t.length(); ++i) {

			int c = (int) t.charAt(i);

			if (letters[c] == 0) { // Found more of char c in t than in s.

				return false;

			}

			--letters[c];

			if (letters[c] == 0) {

				++num_completed_t;

				if (num_completed_t == num_unique_chars) {

					// it’s a match if t has been processed completely

					return i == t.length() - 1;

				}

			}

		}

		return false;
	}

	public static void main(String[] args) {

		String value = "ARARA";
		Instant init = Instant.now();
		System.out
				.println("isAnagramHowIWouldDoDayToDay started: " + init + " - " + isAnagramHowIWouldDoDayToDay(value));
		System.out.println(
				"isAnagramHowIWouldDoDayToDay ANAGRAM " + ChronoUnit.MILLIS.between(init, Instant.now()) + " ms.");

		String s = "cinema";
		String t = "iceman";
		init = Instant.now();
		System.out.println("anagram started: " + init + " - " + anagram(s, t));
		System.out.println(
				"anagram ANAGRAM " + ChronoUnit.MILLIS.between(init, Instant.now()) + " ms.");

		
		System.out.println(isAnagramHowIWouldDoDayToDay("ARARAX"));
	}
}
