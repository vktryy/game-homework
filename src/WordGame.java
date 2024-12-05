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
            String letterStr = scanner.nextLine();
            if (letterStr.equals("exit")) {
                break;
            }
            char letter = letterStr.charAt(0);
            if (finalWord.contains(letterStr)) {
                Right right = new Right();
                hiddenWord = right.getRightResult(letter, word, hiddenWord);
                System.out.println("Right. ");
                int count = 0;
                for (char c : hiddenWord) {
                    if (c != '*') {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if (count == hiddenWord.length) {
                    System.out.println("You won!");
                    System.out.print("Word: ");
                    for (char symbol : hiddenWord) {
                        System.out.print(symbol + " ");
                    }
                    break;
                }
            } else {
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
            System.out.println("Tries left: " + (5 - counter));
            System.out.print("Word: ");
            for (char symbol : hiddenWord) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
