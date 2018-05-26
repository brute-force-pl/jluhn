package pl.brute_force.jluhn.characters.constraints;

public class LuhnCharacterConstraintException extends RuntimeException {
    public LuhnCharacterConstraintException() {
    }

    public LuhnCharacterConstraintException(final String message) {
        super(message);
    }

    public LuhnCharacterConstraintException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LuhnCharacterConstraintException(final Throwable cause) {
        super(cause);
    }

    public LuhnCharacterConstraintException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
