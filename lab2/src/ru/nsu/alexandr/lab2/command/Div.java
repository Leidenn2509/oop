package ru.nsu.alexandr.lab2.command;

import ru.nsu.alexandr.lab2.Calc;
import ru.nsu.alexandr.lab2.CalcException;

import java.util.ArrayList;

public class Div extends Command{
    @Override
    public Double work(ArrayList<Object> param) throws CalcException.WrongParameters {
        if(param.toArray().length != 1) {
            throw new CalcException.WrongParameters("Неверное число параметров!");
        }
        if(!(param.get(0) instanceof Calc)) {
            throw new CalcException.WrongParameters("Не передан контекст");
        }
        calc = (Calc) param.get(0);

        Double a = calc.stack.pop();
        Double b = calc.stack.pop();
        return calc.stack.push(a / b);
    }
}
