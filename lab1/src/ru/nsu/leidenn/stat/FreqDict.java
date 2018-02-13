package ru.nsu.leidenn.stat;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqDict {
    private final Map<String, Integer> dict = new HashMap<>();
    private int size = 0;


    public void add(String word) {
        size++;
        int count = 0;
        if(dict.containsKey(word)) {
            count = dict.get(word);
        }
        dict.put(word, count + 1);
    }

    public void printInFile(Writer writer) throws IOException {
        List<Map.Entry<String, Integer>> list = new ArrayList(dict.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<String, Integer> a : list) {
            writer.write(a.getKey()); writer.write(",");
            writer.write(a.getValue().toString()); writer.write(",");
            writer.write(String.format("%.2f", (double) a.getValue() / size * 100));
            writer.write("\n");
        }

    }

}
