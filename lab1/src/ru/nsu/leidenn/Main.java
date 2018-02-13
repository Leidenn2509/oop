package ru.nsu.leidenn;

import ru.nsu.leidenn.stat.TextStat;

public class Main {
    public static void main(String[] argc ) {
        new TextStat(argc[0], "out.txt");
    }
}
