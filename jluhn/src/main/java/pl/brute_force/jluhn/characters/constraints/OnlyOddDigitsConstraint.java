package pl.brute_force.jluhn.characters.constraints;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlyOddDigitsConstraint implements LuhnCharacterConstraint {
    public Set<Character> validCharacters() {
        /* TODO: use Set.of() in Java 9 release */
        return Stream.of(
                '1',
                '3',
                '5',
                '7',
                '9'
        ).collect(Collectors.toSet());
    }

}
