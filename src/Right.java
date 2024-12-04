public class Right {

    public char[] getRightResult(char letter, char[] word, char[] process) {
        for (int i = 0; i < process.length; i++) {
            if (word[i] == letter) {
                process[i] = letter;
            }
        }
        return process;
    }
}
