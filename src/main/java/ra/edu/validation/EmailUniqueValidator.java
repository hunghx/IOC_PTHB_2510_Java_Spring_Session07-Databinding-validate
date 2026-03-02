package ra.edu.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.edu.sesrvice.UserServiceImpl;

@Component
public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // logic xác thực dữ liệu
        return !userService.existByEmail(value);
    }
}
