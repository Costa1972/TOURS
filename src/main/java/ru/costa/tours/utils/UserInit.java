package ru.costa.tours.utils;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.costa.tours.models.*;
import ru.costa.tours.repositories.PassportRepository;
import ru.costa.tours.repositories.RoleRepository;
import ru.costa.tours.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ru.costa.tours.models.PaymentBasis.*;

@Component
@Transactional
public class UserInit {

    private static final Logger logger = LoggerFactory.getLogger(UserInit.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PassportRepository passportRepository;

    public UserInit(UserRepository userRepository,
                    RoleRepository roleRepository,
                    PassportRepository passportRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passportRepository = passportRepository;

        Role admin = checkRole("ADMIN", roleRepository);
        Role user = checkRole("USER", roleRepository);
        List<Role> roles = new ArrayList<>();
        roles.add(admin);
        roles.add(user);

        Passport passport_1 = new Passport(0L, "45 12", "654390");
        Passport passport_2 = new Passport(0L, "43 67", "675678");

        Payment payment_1 = new Payment(0L, 289, Set.of(TRAIN, BUS));
        Payment payment_2 = new Payment(0L, 500, Set.of(HOTEL, BUS));


        User user_1 = User.builder()
                .id(0L)
                .firstName("Anton")
                .patronymic("Antonovoch")
                .lastName("Antonov")
                .email("anton@mail.ru")
                .password("$2a$16$jshzIDJgNp7Bg0GVn3CFOen5o7miO2lfgQeZBW2t5B.crNeI5ZiaS")
                .phone("+7 495 876-90-90")
                .passport(passport_1)
                .roles(Set.of(admin))
                .payments(Set.of(payment_1))
                .build();
        User user_2 = User.builder()
                .id(0L)
                .firstName("Oleg")
                .patronymic("Petrovich")
                .lastName("Smirnov")
                .email("oleg@mail.ru")
                .password("$2a$16$Ek9k9F32oL4Y01kYJGq67eWeCE3juvsnrWD.UEZIeY/YCi46yYc2C")
                .phone("+7 495 876-87-53")
                .passport(passport_2)
                .roles(Set.of(user))
                .payments(Set.of(payment_2))
                .build();
        userRepository.save(user_1);
        userRepository.save(user_2);
        logger.info("Person init successful");
    }

    private Role checkRole(String roleName, RoleRepository roleRepository) {
        return roleRepository.findByName(roleName)
                .orElseGet(() -> roleRepository.save(Role.builder().name(roleName).build()));
    }
}
