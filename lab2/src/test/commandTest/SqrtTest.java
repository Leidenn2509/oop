package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Sqrt;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    private Context context;

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() {
        context.push(9.0);
        assertTrue((new Sqrt()).work(context, new String[0]) == 3.0);
        context.push(-3.5);
        assertThrows(ArithmeticException.class, () -> (new Sqrt()).work(context, new String[0]));
        context = new Context();
        assertThrows(EmptyStackException.class, () -> (new Sqrt()).work(context, new String[0]));
    }
}