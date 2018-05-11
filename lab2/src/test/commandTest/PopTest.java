package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Pop;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

    private Context context;
    private Pop pop = new Pop();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);
        assertTrue(pop.work(context, new String[0]).equals(2.2));
        assertTrue(pop.work(context, new String[0]).equals(1.1));
        assertThrows(EmptyStackException.class, () -> pop.work(context, new String[0]));
    }
}