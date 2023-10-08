package week3.designPattern.dependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckerWithHardWiring {
    private final Dictionary dictionary = new EnglishDictionary(); // this is hardWiring

    public SpellCheckerWithHardWiring() {
    }

    public boolean checkSpell(String word) {
        return dictionary.isValid(word);
    }

    public List<String> correctSpelling(String wordWithTypo) {
        List<String> list = new ArrayList<>();
        // some code that uses dictionary's suggest method

        return list;
    }
}
