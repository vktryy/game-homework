import java.util.Objects;
import java.util.Scanner;

public class WordGame {

    private String finalWord;
    private final Words words = new Words();

    WordGame () {
        int randomNumber = Choice.choose();
        this.finalWord = words.getGameWord(randomNumber);
    }

    public char[] getHiddenWord(char[] word) {
        int size = word.length;
        char[] pros = new char[size];
        for (int i = 0; i < word.length; i++){
            pros[i] = '*';
        }
        return pros;
    }

    public void startGame() {
        char[] word = finalWord.toCharArray();
        char[] hiddenWord = getHiddenWord(word);
        int counter = 0;
        System.out.print("Word: ");
        for (char star : hiddenWord) {
            System.out.print(star + " ");
        }
        System.out.println();
        while (true) {
            System.out.println("Введите букву или exit для выхода");
            Scanner scanner = new Scanner(System.in);
            char letter = scanner.next().charAt(0);
            String leter = "" + letter;
            if (Objects.equals(leter, "exit")) {
                break;
            }
            if (finalWord.contains(leter)){
                Right outr = new Right();
                hiddenWord = outr.getRightResult(letter, word, hiddenWord);
                System.out.println("Right. ");
                int count = 0;
                for (int i = 0; i < hiddenWord.length; i++) {
                    if (hiddenWord[i] !=  '*') {
                        count++;
                    }
                    else {
                        count = 0;
                    }
                }
                if (count == hiddenWord.length) {
                    System.out.println("You won!");
                    System.out.print("Word: ");
                    for (char star : hiddenWord) {
                        System.out.print(star + " ");
                    }
                    break;
                }
            }
            else {
                counter ++;
                System.out.println("Wrong. ");
                if (counter == 5) {
                    System.out.println("|______|");
                    System.out.println("|      o");
                    System.out.println("|     /|\\ ");
                    System.out.println("|     / \\");
                    System.out.println("--------");
                    System.out.println("You lost");
                    break;
                }
            }
            System.out.println("Tries left: " + (5 - counter) + " out of 5." );
            System.out.print("Word: ");
            for (char star : hiddenWord) {
                System.out.print(star + " ");
            }
            System.out.println();
        }
    }
}
