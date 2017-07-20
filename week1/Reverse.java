package week1;

public class Reverse {
	public String reverseWords(String a) {
	    String reversedSentence = reverse(a);
        String[] reversedWords = reversedSentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < reversedWords.length; i++) {
            sb.append(reverse(reversedWords[i]) + " ");
        }
        return sb.toString().trim();
	}
	
	private String reverse(String str) {
        char[] chars = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
