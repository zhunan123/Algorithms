package week3.designPattern.dependencyInjection;

import java.util.List;

public class SpellCheckerNoHardwiring {
    private final Dictionary dictionary;

    public SpellCheckerNoHardwiring(EnglishDictionary edict) {
        this.dictionary = edict;
    }

    public boolean checkSpell(String word) {
        return dictionary.isValid(word);
    }

    public List<String> wordWithNoType(String wordNoTypo) {
        return dictionary.suggest(wordNoTypo);
    }
}
