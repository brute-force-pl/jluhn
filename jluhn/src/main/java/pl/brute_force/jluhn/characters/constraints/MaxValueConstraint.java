package pl.brute_force.jluhn.characters.constraints;

import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class MaxValueConstraint implements LuhnCharacterConstraint {

    private final short max;

    public Set<Character> validCharacters() {
        return IntStream.rangeClosed(0, max).mapToObj(i -> Character.forDigit(i, 10)).collect(Collectors.toSet());
    }
}
