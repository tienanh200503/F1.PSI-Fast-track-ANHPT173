package com.tienanh.anhpt173.user.service;

import com.tienanh.anhpt173.notification.EmailService;
import com.tienanh.anhpt173.user.model.User;
import com.tienanh.anhpt173.user.repository.UserRepository;
import com.tienanh.anhpt173.user.validation.UserValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRegistrationService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordHasher hasher;

    public void register(User request){
        if(!userValidator.isValidEmail(request.getEmail()) || !userValidator.isValidPassword(request.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        String hashed = hasher.hash(request.getPasswordHash());
        User user = new User(request.getEmail(), hashed);
        userRepository.save(user);
        emailService.sendWelcomeEmail(user.getEmail());
    }


}
