package ru.nsu.alexandr.lab2.command;

import ru.nsu.alexandr.lab2.Calc;
import ru.nsu.alexandr.lab2.CalcException;

import java.util.ArrayList;

public class Push extends Command{

    @Override
    public Double work(ArrayList<Object> param) throws CalcException.WrongParameters {
        int size = param.toArray().length;
        if(size < 2) {
            throw new CalcException.WrongParameters("Неверное число параметров!");
        }
        if(!(param.get(0) instanceof Calc)) {
            throw new CalcException.WrongParameters("Не передан контекст");
        }
        calc = (Calc) param.get(0);

        Double a = 0.0;

        for(int i = 0; i < size - 1; i++) {
            if(!(param.get(1 + i) instanceof Double)) {
                if(!(param.get(1 + i) instanceof String)) {
                    throw new CalcException.WrongParameters("Неверный тип аргумента");
                } else {
                    a = calc.table.get(param.get(1 + i));
                }
            } else {
                a = (Double)param.get(1 + i);
            }
            calc.stack.push(a);
        }




        return a;
    }

}
