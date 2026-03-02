package ra.edu.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import ra.edu.validation.EmailUnique;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class UserDtoRequest {
    @NotNull(message = "Khong đươc để trông !!")
    @Pattern(regexp = "^U[0-9]{3}$")
    private String userId;
    @NotBlank
    @Size(min = 6, max = 30)
    private String username;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\w\\D][a-zA-Z0-9\\w][a-zA-Z0-9].$")
    private String password;
    @NotNull
    @Past
    private LocalDate birthDate;
    @Email
    @EmailUnique
    private String email;
    private String phone;
    @Min(value = 0)
    @Max(value = 3)
    private BigDecimal height;
    @NotNull
    @Positive
    private Integer numberSerial; // ko th là số âm
}
