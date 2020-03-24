package be.jkin.counter;

public class Word {
    private String word;
    private int wordCounter;

    public Word(String word){
        this.word = word;
        this.wordCounter = 1;
    }

    public void incrementWordCounter(){
        this.wordCounter += 1;
    }

    public String getWord(){
        return this.word;
    }

    public String getWordAndCounter(){
        return this.word + " " + this.wordCounter;
    }

}
