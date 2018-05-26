package pl.brute_force.jluhn.characters.constraints;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlyDigitsConstraint implements LuhnCharacterConstraint {
    /* TODO: use Set.of() in Java 9 release */
    static final Set<Character> VALID_CHARACTERS = Stream.of(
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9'
    ).collect(Collectors.toSet());

    public Set<Character> validCharacters() {
        return VALID_CHARACTERS;
    }

}
