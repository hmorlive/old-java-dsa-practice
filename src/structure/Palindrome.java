package structure;

public class Palindrome {
	public String longestPal(String sequence) {
		String subSeq = "", longSeq = "";
		boolean isPal = true;
		int count = sequence.length();
		
		for(int i = 0; i < count; i++) {
			subSeq = Character.toString(sequence.charAt(i));			
			for (int j = i + 1; j < count; j++) {
				subSeq += Character.toString(sequence.charAt(j));
				int pointer = subSeq.length();
				for (int check = 0; check < subSeq.length(); check++) {
					if (!(subSeq.charAt(check) == subSeq.charAt(--pointer))) isPal = false;
				} 
				if (isPal == true) {
					if (subSeq.length() > longSeq.length()) longSeq = subSeq;
				}
				isPal = true;
			}
		}
		return longSeq;		
	}
}
