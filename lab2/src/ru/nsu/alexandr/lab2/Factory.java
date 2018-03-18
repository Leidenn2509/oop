package ru.nsu.alexandr.lab2;

import ru.nsu.alexandr.lab2.command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Factory {
    private HashMap<String, String> cfg = new HashMap<>();

    Factory() {
        this("cfg");
    }

    Factory(String cfgName) {
        InputStream is = Factory.class.getResourceAsStream(cfgName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] buf = line.split(" ");
                cfg.put(buf[0], buf[1]);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());

        }
    }

    public Command getCommandByName(String name) {
        try {
            Class cmd = Class.forName(cfg.get(name));
            return (Command) cmd.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printCfg() {
        for (Map.Entry<String, String> entry : cfg.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "|" + value);
        }
    }
}
