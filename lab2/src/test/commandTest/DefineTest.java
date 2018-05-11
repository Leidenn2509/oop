package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Define;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    private Context context;
    private Define define = new Define();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);

        assertTrue(define.work(context, "a 15".split(" ")) == null);
        assertTrue(define.work(context, "a 16".split(" ")).equals((Double) 15.0));
        assertThrows(CalcException.WrongParameters.class, () -> define.work(context, "a".split(" ")));
        assertThrows(CalcException.WrongParameters.class, () -> define.work(context, "a 15 2".split(" ")));
    }
}