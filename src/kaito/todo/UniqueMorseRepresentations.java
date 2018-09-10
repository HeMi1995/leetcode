package kaito.todo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kaito
 * @date 2018/9/10 12:36 PM
 */
public class UniqueMorseRepresentations {
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseWords = new HashSet<>(words.length);
        StringBuilder sb;
        for (String word : words) {
            sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[((int) c - 'a')]);
            }
            morseWords.add(sb.toString());
        }
        return morseWords.size();
    }
}
