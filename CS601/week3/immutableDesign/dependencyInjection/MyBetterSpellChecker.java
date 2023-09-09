package week3.immutableDesign.dependencyInjection;

public class MyBetterSpellChecker {
    private Dictionary dictionary;

    public MyBetterSpellChecker(Dictionary dict) { // if passed in is interface, it can be any classes that implement this interface, so the code is more general
        this.dictionary = dict;
    }

    public boolean checkSpelling(String word) {
        return dictionary.isValid(word);
    }
}
