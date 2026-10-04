package employeeLeave.auth.service;

import employeeLeave.auth.dto.RegisterRequestDto;
import employeeLeave.common.constant.EmployeeStatus;
import employeeLeave.common.exception.BusinessException;
import employeeLeave.common.exception.ResourceNotFoundException;
import employeeLeave.employee.entity.Employee;
import employeeLeave.employee.repository.EmployeeRepository;
import employeeLeave.role.entity.Role;
import employeeLeave.role.repository.RoleRepository;
import employeeLeave.user.entity.User;
import employeeLeave.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterRequestDto dto){
        if(userRepository.existsByUsername(dto.getUsername())){
            throw new BusinessException("Username already exists");
        }

        if(employeeRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Username already exists");
        }

        if(employeeRepository.existsByPhone(dto.getPhone())){
            throw new BusinessException("Phone already exists");
        }

        Role employeeRole = roleRepository.findByName(dto.getRole())
                .orElseThrow(() -> new ResourceNotFoundException("Not found role"));

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(employeeRole)
                .enabled("Y")
                .build();

        User savedUser = userRepository.save(user);

        Employee emp = Employee.builder()
                .user(savedUser)
                .employeeCode(generateEmployeeCode(savedUser.getId()))
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .status(EmployeeStatus.ACTIVE)
                .joinDate(LocalDate.now())
                .build();
        employeeRepository.save(emp);
    }

    private String generateEmployeeCode(Long userId) {

        return String.format(
                "EMP%05d",
                userId
        );
    }
}
