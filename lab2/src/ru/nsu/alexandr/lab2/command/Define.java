package ru.nsu.alexandr.lab2.command;

import ru.nsu.alexandr.lab2.Calc;
import ru.nsu.alexandr.lab2.CalcException;

import java.util.ArrayList;

public class Define extends Command{
    @Override
    public Double work(ArrayList<Object> param) throws CalcException.WrongParameters {
        if(param.toArray().length != 3) {
            throw new CalcException.WrongParameters("Неверное число параметров!");
        }
        if(!(param.get(0) instanceof Calc)) {
            throw new CalcException.WrongParameters("Не передан контекст");
        }
        calc = (Calc) param.get(0);

        if(!(param.get(1) instanceof String) || !(param.get(2) instanceof Double)) {
            throw new CalcException.WrongParameters("Неверный тип параметров");
        }

        String key = (String)param.get(1);
        Double value = (Double)param.get(2);

        return calc.table.put(key, value);
    }
}
