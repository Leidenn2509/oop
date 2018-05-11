package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.alexandr.lab2.CalcException;
import ru.nsu.alexandr.lab2.Context;
import ru.nsu.alexandr.lab2.command.Comment;
import ru.nsu.alexandr.lab2.command.Sum;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    private Context context;
    private Comment comment = new Comment();

    @BeforeEach
    void init() {
        context = new Context();
    }

    @Test
    void work() throws CalcException.WrongParameters {
        context.push(1.1);
        context.push(2.2);
        assertTrue(comment.work(context, new String[0]) == null);
    }
}