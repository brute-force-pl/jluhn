package pl.brute_force.jluhn.generator;

import pl.brute_force.jluhn.LuhnCharacter;

import java.util.List;

public interface LuhnGenerator {
    String generate(final List<LuhnCharacter> characters);
}
