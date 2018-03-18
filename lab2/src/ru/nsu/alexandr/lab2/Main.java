package ru.nsu.alexandr.lab2;

import ru.nsu.alexandr.lab2.command.Command;

import java.io.*;
import java.nio.DoubleBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] argv) {
        Factory factory = new Factory();
        Calc calc = new Calc();
        ArrayList<ArrayList<String>> file = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(argv[0]), StandardCharsets.UTF_8))){
            String line;
//            int i = 0;
            while ((line = reader.readLine()) != null) {
//                file.set(i, new ArrayList<>(Arrays.asList(line.split(" "))));
                file.add(new ArrayList<>(Arrays.asList(line.split(" "))));
//                i++;
            }
        } catch (IOException e) {
            // log error
        }
        for (ArrayList<String> line : file) {
            if(line.size() < 1) {
                continue;
            }
            String word = line.get(0).toLowerCase();
            Command cmd = factory.getCommandByName(word);
            ArrayList<Object> param = new ArrayList<>();
            param.add(calc);
            for(int i = 0; i < line.size() - 1; i++ ) {

                try {
                    Double a = Double.parseDouble(line.get(i + 1));
                    param.add(a);
                } catch (NumberFormatException e) {
                    param.add(line.get(i + 1));
                }
            }

            try {
                cmd.work(param);
            } catch (CalcException.WrongParameters wrongParameters) {
                wrongParameters.printStackTrace();
            }
        }

    }
}
