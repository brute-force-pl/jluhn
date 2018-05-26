package pl.brute_force.jluhn.characters.constraints;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlyLatinUpperCaseLettersConstraint implements LuhnCharacterConstraint {

    /* TODO: use Set.of() in Java 9 release */
    public static final Set<Character> VALID_CHARACTERS = Stream.of(
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G',
            'H',
            'I',
            'J',
            'K',
            'L',
            'M',
            'N',
            'O',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'U',
            'V',
            'W',
            'X',
            'Y',
            'Z'
    ).collect(Collectors.toSet());

    public Set<Character> validCharacters() {
        return VALID_CHARACTERS;
    }

}
