package employeeLeave.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String accessToken;

    private String tokenType;

    private Long userId;

    private String username;

    private String role;
}
