package employeeLeave.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^(0[0-9]{9})$", message = "Phone must start with 0 and have 10 digits")
    private String phone;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Role is required")
    private String role;
}
