package week3.immutableDesign.dependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class EnglishDictionary implements Dictionary{
    @Override
    public boolean isValid(String word) {
        return false;
    }

    @Override
    public List<String> suggest(String typo) {
        List<String> list = new ArrayList<>();
        return list;
    }
}
