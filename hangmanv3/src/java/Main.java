

public class Main {
    public static void main(String[] args){

        try {
            System.out.println("HANGMAN");
            Draw.hangmanArt(4);
            HangmanGame hangManGame = new HangmanGame();
            hangManGame.newGame();
            hangManGame.play();
        }catch (Exception e){
            System.out.println("Something went wrong in the Main.main() method.");
        }

    }
}
