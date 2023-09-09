package week3.immutableDesign.dependencyInjection;

public class SpellCheckerWithHardWiring {
    private final Dictionary dictionary = new EnglishDictionary(); // this is hardWiring

    public SpellCheckerWithHardWiring() {
    }

    public boolean checkSpell(String word) {
        return dictionary.isValid(word);
    }
}
