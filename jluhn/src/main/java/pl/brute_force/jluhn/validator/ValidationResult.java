package pl.brute_force.jluhn.validator;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResult {
    private boolean valid;
    @Singular
    private List<ValidationError> errors;
}
