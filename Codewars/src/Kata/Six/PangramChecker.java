package Kata.Six;

import java.util.stream.Stream;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once.
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
 * because it uses the letters A-Z at least once (case is irrelevant).
 *
 * Given a string, detect whether it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class PangramChecker {
    public boolean check(String sentence){
        return Stream.of(sentence.split(""))
                .map(s -> s.toUpperCase().toCharArray()[0])
                .filter(Character::isLetter)
                .distinct()
                .count() == 26;
    }
}
