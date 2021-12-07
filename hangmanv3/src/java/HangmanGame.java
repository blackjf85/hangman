import java.util.*;

public class HangmanGame {

    public static final String[] WORDS = {
            "cowboy", "rodeo", "hat", "boots", "horse", "whiskey", "saloon"
    };

    public static final Random RANDOM = new Random();

    public static final int MAX_ERRORS = 4;

    private String wordToFind;

    private char[] wordFound;

    private int noErrors;

    private final ArrayList<String> letters = new ArrayList<>();

    private final ArrayList<String> missed = new ArrayList<>();

    private String newWordToFind(){
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public void newGame(){
        try{
            noErrors = 0;
            letters.clear();
            missed.clear();
            wordToFind = newWordToFind();
            wordFound = new char[wordToFind.length()];

            Arrays.fill(wordFound, '_');
        }catch (Exception e){
            System.out.println("Failed to start new game in HangmanGam.newGame() method.");
        }
    }

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    public void enter(String c){

        if(!letters.contains(c)){
            if (wordToFind.contains(c)){

                int index = wordToFind.indexOf(c);

                while(index >= 0){
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            }else{

                missed.add(c);
                noErrors++;
            }

            letters.add(c);
        }
    }


    public String wordFoundContent(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++){
            builder.append(wordFound[i]);

            if(i < wordFound.length - 1){
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    public void play(){
        try (Scanner input = new Scanner(System.in)) {

            while (noErrors < MAX_ERRORS){
                System.out.println("Missed letters: " + missed);
                System.out.println("\n" + wordFoundContent());
                System.out.println("Guess a letter:");
                String str = input.next().toLowerCase(Locale.ROOT);

                if (letters.contains(str)){
                    System.out.println("You have already guessed that letter. Choose again.");
                } else{
                    if (str.length() > 1){
                        str = str.substring(0, 1);
                    }
                    enter(str);
                    if (wordFound()){
                        System.out.println("\nYou Win!");
                        break;
                    }
                    else{
                        System.out.println("\n=> Tries remaining: " + (MAX_ERRORS - noErrors));
                        Draw.hangmanArt((MAX_ERRORS - noErrors));
                    }
                }
            }
            if (noErrors == MAX_ERRORS){
                System.out.println("\nYou lose!");
                System.out.println("The word was: " + wordToFind);
            }
        }
    }
}
