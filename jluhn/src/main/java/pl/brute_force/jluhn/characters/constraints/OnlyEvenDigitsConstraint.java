package pl.brute_force.jluhn.characters.constraints;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlyEvenDigitsConstraint implements LuhnCharacterConstraint {
    public Set<Character> validCharacters() {
        /* TODO: use Set.of() in Java 9 release */
        return Stream.of(
                '0',
                '2',
                '4',
                '6',
                '8'
        ).collect(Collectors.toSet());
    }

}
