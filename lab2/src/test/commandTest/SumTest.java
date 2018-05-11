package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {
    private Context context;
    private Sum sum = new Sum();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);
        assertTrue(sum.work(context, new String[0]) == 1.1 + 2.2);
        assertThrows(EmptyStackException.class, () -> sum.work(context, new String[0]));
        assertTrue(context.peek().equals(2.2 + 1.1));
    }
}