package com.cursos.api.springsecuritycourse.service.impl;

import com.cursos.api.springsecuritycourse.dto.SaveUser;
import com.cursos.api.springsecuritycourse.exception.InvalidPasswordException;
import com.cursos.api.springsecuritycourse.persistence.entity.User;
import com.cursos.api.springsecuritycourse.persistence.repository.UserRepository;
import com.cursos.api.springsecuritycourse.persistence.util.Role;
import com.cursos.api.springsecuritycourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerOneCustomer(SaveUser newUser) {
        validatePassword(newUser);


        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setName(newUser.getName());
        user.setRole(Role.ROLE_CUSTOMER);

        return userRepository.save(user);
    }

    private void validatePassword(SaveUser dto) {
        if(!StringUtils.hasText(dto.getPassword())|| !StringUtils.hasText(dto.getRepeatPassword())){
            throw new InvalidPasswordException("No coinciden las contraseñas");
        }
        if(!dto.getPassword().equals(dto.getRepeatPassword())){
            throw new InvalidPasswordException("No coinciden las contraseñas");
        }
    }
}
