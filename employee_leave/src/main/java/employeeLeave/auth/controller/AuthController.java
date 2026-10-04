package employeeLeave.auth.controller;

import employeeLeave.auth.dto.RegisterRequestDto;
import employeeLeave.auth.service.AuthService;
import employeeLeave.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@Valid RegisterRequestDto dto){
        authService.register(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success("Register successfully", null)
                );
    }



}
