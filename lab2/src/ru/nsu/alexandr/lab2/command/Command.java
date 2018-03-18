package ru.nsu.alexandr.lab2.command;

import ru.nsu.alexandr.lab2.Calc;
import ru.nsu.alexandr.lab2.CalcException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public abstract class Command {
    Calc calc;

    public abstract Double work(ArrayList<Object> param) throws CalcException.WrongParameters;;
}
