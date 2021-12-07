import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DrawTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void hangmanArt() {
        System.out.println("+---+\n      |\n      |\n      |\n     ===\n");

        assertEquals();
    }

    private void assertEquals() {
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

}