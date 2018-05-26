package pl.brute_force.jluhn.characters;


import pl.brute_force.jluhn.LuhnCharacter;

import java.util.List;

public interface LuhnCharacterValidator {
    void validate(final List<LuhnCharacter> characters);

    void validate(final LuhnCharacter character);
}
