package reflection.week10;

import reflection.week10.logic.WordAnalyst;
import reflection.week10.parser.WordParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new WordParser().getWords();
        WordAnalyst wordAnalyst = new WordAnalyst(words);

        System.out.println(wordAnalyst.getCountOfWords());

        System.out.println(wordAnalyst.getDistinctCountOfWords());

        System.out.println(wordAnalyst.getLongestWord());

        wordAnalyst.getMostAppearingFiveWords().forEach(System.out::println);

        wordAnalyst.getMostAppearingFiveLetters().forEach(System.out::println);

        System.out.println(wordAnalyst.getAliceAppearances());
    }
}
