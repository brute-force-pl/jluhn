package pl.brute_force.jluhn.validator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
    private String message;
    private int position;
    private ErrorCode errorCode;

    public static enum ErrorCode {
        INVALID_LENGTH,
        INVALID_CHECKSUM,
        INVALID_CHARACTER
    }

}
