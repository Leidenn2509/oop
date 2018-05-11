package test;

import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.Factory;
import ru.nsu.alexandr.lab2.command.Command;
import ru.nsu.alexandr.lab2.command.Mul;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void getCommandByName() {
        Factory factory = new Factory("cfg");

        try {
            assertTrue(factory.getCommandByName("mul").getClass() == Mul.class);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        assertThrows(ClassNotFoundException.class, () -> factory.getCommandByName("test"));
    }
}