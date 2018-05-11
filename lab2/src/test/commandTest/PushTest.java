package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Define;
import ru.nsu.alexandr.lab2.command.Push;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    private Context context;
    private Push push = new Push();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        assertTrue(push.work(context, "5".split(" ")).equals(5.0));
        assertTrue(context.peek().equals(5.0));
        Define def = new Define();
        def.work(context, "a 14".split(" "));
        assertTrue(push.work(context, "a 6 8.8".split(" ")).equals(8.8));
        assertTrue(context.pop().equals(8.8));
        assertTrue(context.pop().equals(6.0));
        assertTrue(context.pop().equals(14.0));
        assertThrows(CalcException.WrongParameters.class, () -> push.work(context, new String[0]));
    }
}