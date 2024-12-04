public class Words {

    private String gameWord;
    private final String[] gameWords = {"apple", "banana", "pear", "peach", "kiwi", "melon", "orange"};

    public String getGameWord(int num) {
        this.gameWord = gameWords[num];
        return gameWord;
    }
}