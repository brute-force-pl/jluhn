package pl.brute_force.jluhn.validator;

import pl.brute_force.jluhn.LuhnCharacter;

import java.util.List;

public interface LuhnValidator {
    ValidationResult validate(final String strToValidate, final List<LuhnCharacter> characters);
}
