package ru.nsu.alexandr.lab2.command;

import ru.nsu.alexandr.lab2.Calc;
import ru.nsu.alexandr.lab2.CalcException;

import java.util.ArrayList;

public class Pop extends Command {
    @Override
    public Double work(ArrayList<Object> param) throws CalcException.WrongParameters {
        if(param.toArray().length != 1) {
            throw new CalcException.WrongParameters("Неверное число параметров!");
        }
        if(!(param.get(0) instanceof Calc)) {
            throw new CalcException.WrongParameters("Не передан контекст");
        }
        calc = (Calc) param.get(0);

        return calc.stack.pop();
    }
}
