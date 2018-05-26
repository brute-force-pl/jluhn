package pl.brute_force.jluhn;

import lombok.*;
import pl.brute_force.jluhn.characters.constraints.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LuhnCharacter {
    public static final Character[] LUHN_ALPHABET = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static final Character[] LUHN_CHECKSUM = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private Short weight;
    private boolean checksum;
    @Singular
    private Set<LuhnCharacterConstraint> constraints;

    public boolean isValid(char chr) {
        /* TODO: Use stream() in Java 9 release */
        return Optional
                .ofNullable(constraints)
                .orElseGet(HashSet::new)
                .stream()
                .allMatch(constraint -> constraint.isValid(chr));
    }

    public List<Character> getValidCharacters() {
        if (checksum) {
            return asList(LUHN_CHECKSUM);
        }
        return Stream
                .of(LUHN_ALPHABET)
                .filter(this::isValid)
                .collect(Collectors.toList());
    }

    public static class LuhnCharacterBuilder {

        public LuhnCharacterBuilder odd() {
            this.constraints.add(new OnlyOddDigitsConstraint());
            return this;
        }

        public LuhnCharacterBuilder even() {
            this.constraints.add(new OnlyEvenDigitsConstraint());
            return this;
        }

        public LuhnCharacterBuilder value(char value) {
            this.constraints.add(new ValueConstraint(value));
            return this;
        }

        public LuhnCharacterBuilder latinUpperCase() {
            this.constraints.add(new OnlyLatinUpperCaseLettersConstraint());
            return this;
        }

        public LuhnCharacterBuilder checksum(final boolean checksum) {
            if (checksum) {
                return checksum();
            } else {
                this.checksum = false;
                return this;
            }
        }

        public LuhnCharacterBuilder checksum() {
            if (this.weight != null) {
                throw new LuhnCharacterConstraintException("Checksum cannot have any weight");
            }
            return this;
        }

        public LuhnCharacterBuilder weight(final short weight) {
            if (this.checksum) {
                throw new LuhnCharacterConstraintException("Checksum cannot have any weight");
            }
            this.weight = weight;
            return this;
        }

    }

}
