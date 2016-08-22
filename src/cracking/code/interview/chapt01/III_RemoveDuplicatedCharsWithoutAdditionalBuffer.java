package cracking.code.interview.chapt01;

public class III_RemoveDuplicatedCharsWithoutAdditionalBuffer {
	
	public static void removeDuplicatedChars(String value){
		if(value==null) return;
		int len = value.length();
		if(len < 2) return;
		
		char[] str = value.toCharArray();
		
		int tail = 1;
		for(int i = 1; i < len; ++i){
			int j;
			for(j=0;j < tail; ++j){
				if(str[i] == str[j]) break;
				
			}
			
			if(j == tail){
				str[tail] = str[i];
				++tail;
			}
		}
		
		str[tail] = 0;
		
	}
	
	
	
	public static void main(String[] args) {
		
		String value = "abcdefghijklmnopqrstuvwxyz";
		removeDuplicatedChars(value);
		
		value = "abcdefghijklmnopqrstuvwxyza";
		removeDuplicatedChars(value);
		
		value = "abcdefgGhijklmnopqrstuvwxyz";
		removeDuplicatedChars(value);
		
	}


}
