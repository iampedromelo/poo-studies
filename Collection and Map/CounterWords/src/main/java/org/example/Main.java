package org.example;

import java.util.*;

public class Main {
    static void main() {
        System.out.println("Type as many words as you want using blank space as a separator: ");
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = List.of(scanner.nextLine().toLowerCase().split(" "));

        Set<String> wordsSet = new TreeSet<>(wordsList);

        Map<String,Integer> wordsMap = new TreeMap<>();
        for (String string : wordsList){
            wordsMap.put(string, wordsMap.getOrDefault(string,0) + 1);
        }

        System.out.println("All the words typed: ");
        System.out.println(wordsList);

        System.out.println("All the words typed without repetition in alphabetical order: ");
        System.out.println(wordsSet);

        System.out.println("All the words with the frequency of appearance: ");
        System.out.println(wordsMap);

        //another way, with less time complexity
        List<String> wordsList2 = new ArrayList<>();
        Set<String> wordsSet2 = new TreeSet<>();
        Map<String,Integer> wordsMap2 = new HashMap<>();
        System.out.println("Type as many words as you want, typing enter between them: ");
        do {
            String line = scanner.nextLine().toLowerCase();
            if(line.isEmpty()) break;
            wordsList2.add(line);
            wordsSet2.add(line);
            wordsMap2.put(line,wordsMap2.getOrDefault(line,0) + 1);
        }while(scanner.hasNextLine());

        System.out.println("All the words typed: ");
        System.out.println(wordsList2);

        System.out.println("All the words typed without repetition in alphabetical order: ");
        System.out.println(wordsSet2);

        System.out.println("All the words with the frequency of appearance: ");
        System.out.println(wordsMap2);



    }
}
