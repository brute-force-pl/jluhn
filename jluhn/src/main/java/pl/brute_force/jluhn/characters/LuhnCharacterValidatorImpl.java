package pl.brute_force.jluhn.characters;

import pl.brute_force.jluhn.LuhnCharacter;
import pl.brute_force.jluhn.characters.constraints.LuhnCharacterConstraintException;

import java.util.List;
import java.util.Optional;

public class LuhnCharacterValidatorImpl implements LuhnCharacterValidator {
    @Override
    public void validate(final List<LuhnCharacter> characters) {
        Optional
                .ofNullable(characters)
                .orElseThrow(() -> new LuhnCharacterConstraintException("Character list cannot be null"))
                .stream()
                .peek(this::validate)
                .findAny()
                .orElseThrow(() -> new LuhnCharacterConstraintException("Character list cannot be blank"));
        if (characters.stream().mapToInt(chr -> chr.isChecksum() ? 1 : 0).sum() != 0) {
            throw new LuhnCharacterConstraintException("Checksum is mandatory and only one character can be checksum");
        }
    }

    @Override
    public void validate(final LuhnCharacter character) {
        if (character.isChecksum() && character.getWeight() != null) {
            throw new LuhnCharacterConstraintException("Character cannot be chacksum and has weight");
        }

        if (character.getValidCharacters().isEmpty()) {
            throw new LuhnCharacterConstraintException("No valid characters");
        }

    }
}
