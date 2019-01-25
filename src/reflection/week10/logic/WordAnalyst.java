package reflection.week10.logic;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordAnalyst {

    private List<String> words;

    public WordAnalyst(List<String> words) {
        this.words = words;
    }

    public int getCountOfWords() {
        return words.size();
    }

    public long getDistinctCountOfWords() {
        return words.stream()
                .distinct()
                .count();
    }

    public List<String> getLongestWord() {
        return words.stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(1)
                .collect(Collectors.toList());
    }

    public List<String> getMostAppearingFiveWords() {
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(5)
                .map(entry -> entry.getValue() + "\t| " + entry.getKey())
                .collect(Collectors.toList());
    }

    public List<String> getMostAppearingFiveLetters() {
        return words.stream()
                .map(s -> s.split(""))
                .flatMap(Stream::of)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(5)
                .map(entry -> entry.getValue() + "\t| " + entry.getKey())
                .collect(Collectors.toList());
    }

    public long getAliceAppearances(){
        return words.stream()
                .filter(s -> s.equals("Alice".toLowerCase()))
                .count();
    }
}
