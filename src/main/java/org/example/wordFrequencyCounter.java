package org.example;

import java.io.*;
import java.util.*;
import java.io.IOException;

/**
 * Count word frequency and print word frequency to console sorted by frequency
 * in reversed order
 */
public class wordFrequencyCounter {


    private final String filePath = "src\\main\\resources\\task3\\words.txt";

    public void calculateAndPrint() {

        String stringFromFile;
        String[] splitedString;
        Map<String, Integer> wordFrequency = new HashMap<String, Integer>(); // saves word,frequency pair, word as key
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader("src\\main\\resources\\task3\\words.txt"))) {
            while((stringFromFile = bufferedReader.readLine()) != null){

                  splitedString = stringFromFile.split("\\s+"); // convert stringFromFile to string array
                for (String s : splitedString) { // fill  wordFrequency hashmap

                    if (wordFrequency.containsKey(s)) {

                        wordFrequency.put(s, wordFrequency.get(s) + 1);

                    } else {
                        wordFrequency.put(s, 1);

                    }
                }
            }
           // System.out.println(wordFrequency);
            // sort wordFrequency in reversed oder using the java.util.Collections.sort(List<T> list, Comparator<? super T> c) method.

            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFrequency.entrySet());

            // sorting by values using comparator
           // Collections.sort(list,Comparator.comparing(Map.Entry::getValue)); --->natural order

            Comparator<Map.Entry<String, Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue);
            Collections.sort(list, valueComparator.reversed()); // reversed oder

            for (Map.Entry<String, Integer> entry : list) {

                System.out.println(entry.getKey() + " " + entry.getValue());
            }



        }catch (FileNotFoundException exception){
            System.out.println( exception.getMessage());

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}