package lesson2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input file path: ");
        String fileName = in.nextLine();
        try {
            String text = Files.readString(Path.of(fileName));
            go(text);
        } catch (IOException e) {
            System.out.println("File Not Found. \nExample: C:/IBS_Course/lesson1/src/main/java/lesson2/text.txt");
        }
    }

    private static void go(String text) {
        String[] words = text.split("\\P{L}+");
        System.out.println(Arrays.toString(words));
        Map<String, Integer> wordCountTable = new TreeMap<>();
        int maxInt = 0;
        List<String> maxWord = new ArrayList<>();

        for (String word : words) {
            String uniqueWord = word.toLowerCase();
            if (wordCountTable.containsKey(uniqueWord)) {
                wordCountTable.replace(uniqueWord, wordCountTable.get(uniqueWord),
                        wordCountTable.get(uniqueWord) + 1);
                if (maxInt < wordCountTable.get(uniqueWord)) {
                    maxWord.clear();
                    maxInt = wordCountTable.get(uniqueWord);
                    maxWord.add(word);
                }
                if ((!maxWord.contains(word)) && maxInt == wordCountTable.get(uniqueWord)) {
                    maxWord.add(word);
                }

            } else {
                wordCountTable.put(uniqueWord, 1);
            }
        }
        System.out.println("по алфавиту: " + wordCountTable);
        System.out.println("Слово, встречающееся максимальное число раз: " + maxWord);
        for (String key : wordCountTable.keySet()) {
            System.out.println(key + ": " + wordCountTable.get(key) + " | " + String.format("%.1f",
                    wordCountTable.get(key) / (float)words.length * 100) + "%");
        }
    }
}
