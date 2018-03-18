package ru.nsu.alexandr.lab2;

import java.util.HashMap;
import java.util.Stack;

public class Calc {
    public Stack<Double> stack;
    public HashMap<String, Double> table;

    Calc() {
        stack = new Stack<>();
        table = new HashMap<>();
    }

//    public Double push(Double a) {
//        return stack.push(a);
//    }
}
