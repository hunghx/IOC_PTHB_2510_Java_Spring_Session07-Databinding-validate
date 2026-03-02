package ra.edu.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailUniqueValidator.class})
public @interface EmailUnique { // custom annotation
    String message() default "Email không thể trùng !!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
