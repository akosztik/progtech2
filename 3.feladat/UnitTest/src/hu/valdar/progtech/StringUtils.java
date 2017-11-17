package hu.valdar.progtech;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils(){
        throw new IllegalStateException("Util osztalybol nem lehet több példányt létrehozni!");
    }

    public static List<String> filterTexts(String word, Collection<String> texts){
        return texts.stream()
                .filter(Objects::nonNull)
                .filter((text) -> text.contains(word))
                .collect(Collectors.toList());
    }

    public static boolean containsWord(String word, Collection<String> texts){
        return texts.stream()
                .filter(Objects::nonNull)
                .anyMatch((text) -> text.contains(word));
    }

    public static boolean allTextContains(String word, Collection<String> texts){
        return texts.stream()
                .filter(Objects::nonNull)
                .allMatch((text) -> text.contains(word));
    }



}
