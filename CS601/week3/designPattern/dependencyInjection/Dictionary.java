package week3.designPattern.dependencyInjection;

import java.util.List;

public interface Dictionary {
    boolean isValid(String word);
    List<String> suggest(String typo);
}
