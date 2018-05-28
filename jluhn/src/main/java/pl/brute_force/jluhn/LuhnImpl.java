package pl.brute_force.jluhn;

import pl.brute_force.jluhn.generator.LuhnGenerator;
import pl.brute_force.jluhn.validator.LuhnValidator;
import pl.brute_force.jluhn.validator.ValidationResult;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LuhnImpl implements Luhn {

    private final LuhnGenerator luhnGenerator;

    private final LuhnValidator luhnValidator;

    @Override
    public String generate(final List<LuhnCharacter> characters) {
        return luhnGenerator.generate(characters);
    }

    @Override
    public ValidationResult validate(final String strToValidate, final List<LuhnCharacter> characters) {
        return luhnValidator.validate(strToValidate, characters);
    }
}
