package pl.brute_force.jluhn.checksum;

import pl.brute_force.jluhn.LuhnCharacter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChecksumCalculatorImpl implements ChecksumCalculator {

    /* TODO: make it beautiful :) */
    private static final Map<Character, Integer> CHAR_VALUES = new HashMap<Character, Integer>() {{
        for (int i = 0; i < 10; i++) {
            put(Character.forDigit(i, 10), i);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            put(c, 10 + (c - 'a'));
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            put(c, 10 + (c - 'A'));
        }

    }};

    @Override
    public int calculateChecksum(final String number, final List<LuhnCharacter> characters) {
        return calculateChecksum(number.chars().mapToObj(e -> (char) e).collect(Collectors.toList()), characters);
    }

    @Override
    public int calculateChecksum(final List<Character> number, final List<LuhnCharacter> characters) {
        int sum = 0;
        for (int i = 0; i < characters.size(); i++) {
            final LuhnCharacter currentCharacter = characters.get(i);
            if (!currentCharacter.isChecksum()) {
                char currentNumberCharacter = number.get(i);
                sum += getCharacterProdct(currentNumberCharacter, currentCharacter);
            }
        }
        return sum % 10;
    }


    private int getCharacterProdct(final char chr, final LuhnCharacter luhnCharacter) {
        return CHAR_VALUES.get(chr) * luhnCharacter.getWeight();
    }
}
