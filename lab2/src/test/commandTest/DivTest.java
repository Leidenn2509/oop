package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Div;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class DivTest {
    private Context context;
    private Div div = new Div();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);
        assertTrue(div.work(context, new String[0]).equals(2.2/1.1));
        assertThrows(EmptyStackException.class, () -> div.work(context, new String[0]));
        assertTrue(context.peek() == 2.2/1.1);
        context.push(0.0);
        context.push(1.1);
        assertThrows(NumberFormatException.class, () -> div.work(context, new String[0]));
    }
}