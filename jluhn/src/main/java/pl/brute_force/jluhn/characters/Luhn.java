package pl.brute_force.jluhn.characters;

import pl.brute_force.jluhn.LuhnCharacter;
import pl.brute_force.jluhn.validator.ValidationResult;

import java.util.List;

public interface Luhn {
    String generate(final List<LuhnCharacter> characters);

    ValidationResult validate(final String strToValidate, final List<LuhnCharacter> characters);
}
