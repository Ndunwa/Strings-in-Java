import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a paragraph or a lengthy text:");
        String text = scanner.nextLine();

        // Basic text validation
        if (text.isEmpty()) {
            System.out.println("The input text cannot be empty.");
            scanner.close();
            return;
        }

        // Step 2: Character Count
        int characterCount = text.length();
        System.out.println("Total number of characters: " + characterCount);

        // Step 3: Word Count
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);

        // Step 4: Most Common Character
        char mostCommonChar = getMostCommonCharacter(text);
        System.out.println("Most common character: " + mostCommonChar);

        // Step 5: Character Frequency
        System.out.println("Enter a character to check its frequency:");
        String charInput = scanner.next().toLowerCase();
        if (charInput.length() != 1) {
            System.out.println("Please enter a single character.");
        } else {
            char charToCheck = charInput.charAt(0);
            int charFrequency = getCharacterFrequency(text, charToCheck);
            System.out.println("Frequency of '" + charToCheck + "': " + charFrequency);
        }

        // Step 6: Word Frequency
        System.out.println("Enter a word to check its frequency:");
        scanner.nextLine();  // Consume the leftover newline
        String wordToCheck = scanner.nextLine().toLowerCase();
        int wordFrequency = getWordFrequency(words, wordToCheck);
        System.out.println("Frequency of '" + wordToCheck + "': " + wordFrequency);

        // Step 7: Unique Words
        int uniqueWordCount = getUniqueWordCount(words);
        System.out.println("Number of unique words: " + uniqueWordCount);

        scanner.close();
    }

    // Method to find the most common character
    private static char getMostCommonCharacter(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        char mostCommonChar = ' ';
        int maxFrequency = -1;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }
        return mostCommonChar;
    }

    // Method to find the frequency of a specific character (case-insensitive)
    private static int getCharacterFrequency(String text, char charToCheck) {
        int frequency = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (c == charToCheck) {
                frequency++;
            }
        }
        return frequency;
    }

    // Method to find the frequency of a specific word (case-insensitive)
    private static int getWordFrequency(String[] words, String wordToCheck) {
        int frequency = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(wordToCheck)) {
                frequency++;
            }
        }
        return frequency;
    }

    // Method to count the number of unique words (case-insensitive)
    private static int getUniqueWordCount(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords.size();
    }
}
