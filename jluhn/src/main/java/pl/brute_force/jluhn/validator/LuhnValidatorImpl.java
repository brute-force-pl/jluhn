package pl.brute_force.jluhn.validator;

import lombok.RequiredArgsConstructor;
import pl.brute_force.jluhn.LuhnCharacter;
import pl.brute_force.jluhn.characters.LuhnCharacterValidator;
import pl.brute_force.jluhn.checksum.ChecksumCalculator;

import java.util.List;

@RequiredArgsConstructor
public class LuhnValidatorImpl implements LuhnValidator {

    private final LuhnCharacterValidator validator;

    private final ChecksumCalculator checksumCalculator;

    @Override
    public ValidationResult validate(final String strToValidate, final List<LuhnCharacter> characters) {
        validator.validate(characters);
        final ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();
        final int validChecksum = checksumCalculator.calculateChecksum(strToValidate, characters);

        return null;
    }
}
