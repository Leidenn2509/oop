package ru.nsu.leidenn.stat;

import java.io.*;
import java.util.Scanner;

public class TextStat {

    private final FreqDict dict = new FreqDict();


    public TextStat(String inpFile, String outFile) {
        readFile(inpFile);
        writeFile(outFile);
    }

    private void writeFile(String outFile) {
        Writer writer;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(outFile));
            dict.printInFile(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLine(String line) {
        StringBuilder strB = new StringBuilder();
        line = line.toLowerCase();
        for(int i = 0; i < line.length(); ++i) {

            int ch = line.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                if (strB.toString().equals("")) {
                    continue;
                }
                dict.add(strB.toString());
                strB = new StringBuilder();
            } else {
                strB.append((char) ch);
            }
        }
        if(!strB.toString().equals("")) {
            dict.add(strB.toString());
        }
    }

    private void readFile(String inpFile) {
        try {
            File file = new File(inpFile);
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()) {
                String line = scnr.nextLine();
                parseLine(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
