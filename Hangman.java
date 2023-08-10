import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wrongGuess = 0;
        String word = randomWord(words);
        char[] placeholder = printPlaceHolders(word);
        String guess = " ";
        String missedGuess = "";

        while (wrongGuess != 6) {
            System.out.print(gallows[wrongGuess]);

            System.out.print("Word: ");
            for (int i = 0; i < word.length(); i++) {
                System.out.print(placeholder[i] + " ");
            }
            System.out.println("\n");

            System.out.print("Misses: ");
            System.out.println(missedGuess);
            System.out.println(word);
            System.out.print("\nGuess: ");
            guess = scan.next();

            updatePlaceHolder(placeholder, word, guess);
            if (!word.contains(guess)) {
                missedGuess += guess;
                wrongGuess++;
                ;
            }
            if (word.equals(String.valueOf(placeholder))) {
                System.out.println(gallows[wrongGuess]);
                System.out.print("Word: ");
                for (int i = 0; i < word.length(); i++) {
                    System.out.print(placeholder[i] + " ");
                }
                System.out.print("\n");
                System.out.println("\nGOOD WORK!");
                break;
            }
            if (wrongGuess == 6) {
                System.out.println(gallows[6]);
                System.out.println("RIP!");

                System.out.println("\nThe word was: " + word);

            }

        }

    }

    public static String randomWord(String[] words) {

        return words[(int) (Math.random() * words.length)];
    }

    public static char[] printPlaceHolders(String word) {
        char[] placehold = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            placehold[i] = '_';
        }
        return placehold;
    }

    public static char[] updatePlaceHolder(char[] placeholder, String word, String guess) {
        for (int i = 0; i < placeholder.length; i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                placeholder[i] = guess.charAt(0);
            }
        }
        return placeholder;
    }

}
