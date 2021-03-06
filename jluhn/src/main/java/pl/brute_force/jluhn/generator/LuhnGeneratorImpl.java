package pl.brute_force.jluhn.generator;

import lombok.RequiredArgsConstructor;
import pl.brute_force.jluhn.LuhnCharacter;
import pl.brute_force.jluhn.characters.LuhnCharacterValidator;
import pl.brute_force.jluhn.checksum.ChecksumCalculator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LuhnGeneratorImpl implements LuhnGenerator {

    private final Random random = new SecureRandom();

    private final LuhnCharacterValidator validator;

    private final ChecksumCalculator checksumCalculator;

    @Override
    public String generate(final List<LuhnCharacter> characters) {
        validator.validate(characters);
        final List<Character> result = new ArrayList<>(characters.size());
        int checksumIndex = 0;
        for (int i = 0; i < characters.size(); i++) {
            final LuhnCharacter currentCharacter = characters.get(i);
            if (currentCharacter.isChecksum()) {
                checksumIndex = i;
                result.add(i, '0');
            } else {
                final char currentRandomChar = getRandomValidChar(currentCharacter);
                result.add(i, currentRandomChar);
            }
        }
        final int checksum = checksumCalculator.calculateChecksum(result, characters);
        result.add(checksumIndex, Character.forDigit(checksum, 10));
        return result.stream().map(Object::toString).collect(Collectors.joining());

    }

    private char getRandomValidChar(final LuhnCharacter luhnCharacter) {
        List<Character> validCharacters = luhnCharacter.getValidCharacters();
        return validCharacters.get(random.nextInt(validCharacters.size()));
    }


}
