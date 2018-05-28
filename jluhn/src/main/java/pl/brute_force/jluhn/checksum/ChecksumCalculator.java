package pl.brute_force.jluhn.checksum;

import pl.brute_force.jluhn.LuhnCharacter;

import java.util.List;

public interface ChecksumCalculator {

    int calculateChecksum(final String number, final List<LuhnCharacter> characters);

    int calculateChecksum(final List<Character> number, final List<LuhnCharacter> characters);
}
