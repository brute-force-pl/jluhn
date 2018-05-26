package pl.brute_force.jluhn.characters.constraints;

import java.util.Set;

public interface LuhnCharacterConstraint {
    Set<Character> validCharacters();

    default boolean isValid(final char chr) {
        return validCharacters().contains(chr);
    }
}
