package test.commandTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.Context;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ContextTest {
    private Context context;

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void push() {
        context.push(5.0);
        assertTrue(context.peek() == 5.0);

    }

    @Test
    void pop() {
        context.push(3.4);
        context.push(5.7);
        assertTrue(context.pop() == 5.7);
        assertTrue(context.pop() == 3.4);
        assertThrows(EmptyStackException.class, () -> context.pop());
    }

    @Test
    void get() {
        context.put("key", 1.4);
        context.put("key2", 6.6);
        assertTrue(context.get("key") == 1.4);
        assertTrue(context.get("key2") == 6.6);
        assertTrue(context.get("w") == null);
    }

    @Test
    void put() {

    }

    @Test
    void peek() {
        assertThrows(EmptyStackException.class, () -> context.peek());
        context.push(5.5);
        assertTrue(context.peek() == 5.5);
    }
}