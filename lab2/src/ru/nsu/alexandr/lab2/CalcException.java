package ru.nsu.alexandr.lab2;

public class CalcException {
    public static class WrongParameters extends Exception {
        public WrongParameters(String msg) {
            super(msg);
        }
    }
}
