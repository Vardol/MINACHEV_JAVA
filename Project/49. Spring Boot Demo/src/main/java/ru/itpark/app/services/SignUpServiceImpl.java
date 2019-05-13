package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.app.forms.SignUpForm;
import ru.itpark.app.models.Role;
import ru.itpark.app.models.User;
import ru.itpark.app.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .login(form.getLogin().toLowerCase())
                .passwordHash(encoder.encode(form.getPassword()))
                .role(Role.USER)
                .build();

        usersRepository.save(user);
    }
}
