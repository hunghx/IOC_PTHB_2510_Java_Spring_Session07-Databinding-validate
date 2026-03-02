package ra.edu.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreateDTO {
    @NotBlank(message = "Không được để trống!!!")
    @Size(min = 5, max = 50 , message = "Tên phải từ 5 đến 50 kí tự")
    private String fullName;
    @NotBlank(message = "Không được để trống!!!")
    @Email(message = "Email không đung định dạng")
    private String email;
    @Positive(message = "Tổi phải là số nguyên dương")
    @Min(value = 18, message = "TUổi tối thiếu là 18")
    private int age;
    @PositiveOrZero(message = "Không được là số âm")
    private int yearsOfExperience;
}
