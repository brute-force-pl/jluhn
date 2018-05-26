package pl.brute_force.jluhn.characters.constraints;

import java.util.HashSet;
import java.util.Set;

public class AnyDigitOrLatinUpperCaseLetterConstraint implements LuhnCharacterConstraint {

    @Override
    public Set<Character> validCharacters() {
        final Set<Character> result = new HashSet<>();
        result.addAll(OnlyDigitsConstraint.VALID_CHARACTERS);
        result.addAll(OnlyLatinUpperCaseLettersConstraint.VALID_CHARACTERS);
        return result;
    }
}
