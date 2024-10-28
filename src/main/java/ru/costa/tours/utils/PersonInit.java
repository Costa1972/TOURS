package ru.costa.tours.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.costa.tours.models.Passport;
import ru.costa.tours.models.Payment;
import ru.costa.tours.models.PaymentBasis;
import ru.costa.tours.models.Person;
import ru.costa.tours.repositories.PassportRepository;
import ru.costa.tours.repositories.PersonRepository;

import java.util.Set;

@Component
public class PersonInit {

    private static final Logger logger = LoggerFactory.getLogger(PersonInit.class);
    private PersonRepository personRepository;
    private PassportRepository passportRepository;

    public PersonInit(PersonRepository personRepository,
                      PassportRepository passportRepository) {
        Passport passport_1 = new Passport(0L, "45 12", "654390");
        Passport passport_2 = new Passport(0L, "43 67", "675678");

        Payment payment_1 = new Payment(0L, 289, PaymentBasis.builder().id(0L).title("Bus").build());
        Payment payment_2 = new Payment(0L, 500, PaymentBasis.builder().id(0L).title("Meal").build());


        Person person_1 = Person.builder()
                .id(0L)
                .firstName("Anton")
                .patronymic("Antonovoch")
                .lastName("Antonov")
                .email("anton@mail.ru")
                .phone("+7 495 876-90-90")
                .passport(passport_1)
                .payments(Set.of(payment_1))
                .build();
        Person person_2 = Person.builder()
                .id(0L)
                .firstName("Oleg")
                .patronymic("Petrovich")
                .lastName("Smirnov")
                .email("oleg@mail.ru")
                .phone("+7 495 876-87-53")
                .passport(passport_2)
                .payments(Set.of(payment_2))
                .build();
        personRepository.save(person_1);
        personRepository.save(person_2);
        logger.info("Person init successful");
    }
}
