import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HangmanGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    HangmanGame hangmanGame;
    @BeforeEach
    void setUp() {
        hangmanGame = new HangmanGame();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void play() {
        System.out.println("You have already guessed that letter. Choose again.");

        assertEquals("You have already guessed that letter. Choose again.", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}