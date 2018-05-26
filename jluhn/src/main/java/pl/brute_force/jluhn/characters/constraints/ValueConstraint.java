package pl.brute_force.jluhn.characters.constraints;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Set;

@RequiredArgsConstructor
public class ValueConstraint implements LuhnCharacterConstraint {

    private final Character value;

    public Set<Character> validCharacters() {
        return Collections.singleton(value);
    }

    @Override
    public boolean isValid(final char chr) {
        return validCharacters().contains(chr);
    }
}
