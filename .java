import java.util.Scanner;
import java.util.TreeSet;

public class AnagramGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        TreeSet<String> anagrams = generateAnagrams(word);
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    private static TreeSet<String> generateAnagrams(String word) {
        TreeSet<String> result = new TreeSet<>();
        if (word == null || word.length() == 0) {
            result.add("");
            return result;
        }
        
        char firstChar = word.charAt(0);
        String remaining = word.substring(1);
        TreeSet<String> words = generateAnagrams(remaining);
        for (String str : words) {
            for (int i = 0; i <= str.length(); i++) {
                result.add(insertCharAt(str, firstChar, i));
            }
        }
        return result;
    }

    private static String insertCharAt(String str, char ch, int index) {
        String begin = str.substring(0, index);
        String end = str.substring(index);
        return begin + ch + end;
    }
}
