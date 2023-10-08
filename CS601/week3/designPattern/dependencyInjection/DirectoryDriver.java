package week3.designPattern.dependencyInjection;

import java.util.List;

public class DirectoryDriver {
    public static void main(String[] args) {
        Dictionary dictionary = new EnglishDictionary();

        MyBetterSpellChecker checker = new MyBetterSpellChecker(dictionary); // use dependency injection here

        System.out.println(checker.checkSpelling("profesor"));

        List<String> suggestions  = checker.correctSpelling("profesor");
    }
}
