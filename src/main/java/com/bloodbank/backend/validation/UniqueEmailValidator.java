package com.bloodbank.backend.validation;

import com.bloodbank.backend.model.User;
import com.bloodbank.backend.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    public UniqueEmailValidator (
            final UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        User foundEmail = userRepository.findUserByEmail(email);

        return foundEmail == null;
    }

}
