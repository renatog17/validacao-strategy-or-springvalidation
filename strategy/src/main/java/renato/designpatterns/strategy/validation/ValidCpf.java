package renato.designpatterns.strategy.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CpfValidator.class) // Link to the validator class
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCpf {
    String message() default "Invalid CPF"; // Default error message
    Class<?>[] groups() default {}; // Grouping for validations
    Class<? extends Payload>[] payload() default {}; // Additional data to be carried with the annotation
}