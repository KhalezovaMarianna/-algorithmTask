package tasks;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Input String:");
        // String input = scanner.nextLine();
        String input = "the quick brown fox jumps over the lazy dog and the brown fox runs away";
        String[] excludedWord = {"the", "a", "an", "and", "or", "but"};
        String[] words = input.split("\\s+");
        
        Set<String> excludedWords = new HashSet<>(Arrays.asList(excludedWord));
        Map<String, Integer> count = new HashMap<>();

        for (String word : words) {
            if (!excludedWords.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(count.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("Вывод:");
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}