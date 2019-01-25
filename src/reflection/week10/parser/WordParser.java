package reflection.week10.parser;

import exercises.week10.ex01.Reader.FileReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordParser {
    private final String specialCharacters = "[-#*()\\[\\]:‘’;,.\\/]";
    private final String space = " ";
    private final String apostropheS = "’s";
    private List<String> lines = new FileReader().asLines("reflection/week10/data/alice.txt");

    public List<String> getWords(){
        return lines.stream()
                .map(String::toLowerCase)
                .map(s -> s.replace(apostropheS, space))
                .map(s -> s.replaceAll(specialCharacters, space))
                .map(s -> s.split(space))
                .flatMap(Stream::of)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
