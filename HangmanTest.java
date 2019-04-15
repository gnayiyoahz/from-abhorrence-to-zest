/* Hangman Tester Class
*/
import java.util.*;

public class HangmanTest {

    public static void main(String[] args){

        System.out.println("Welcome to the Hangman Game!");

        Scanner input = new Scanner(System.in);
        System.out.println("Please choose file(s).");
        String s = input.nextLine();

        Hangman h = new Hangman();
        h.play(s);

        System.out.println("Thanks for playing!");

    }
}
