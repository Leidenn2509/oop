package ru.nsu.alexandr.lab2;

public class CalcException {
    public static class WrongParameters extends Exception {
        public WrongParameters(String msg) {
            super(msg);
        }
    }

    public static class EmptyStack extends Exception {
        public EmptyStack(String msg) { super(msg); }
    }

}
