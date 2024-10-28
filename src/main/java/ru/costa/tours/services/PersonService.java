package ru.costa.tours.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.costa.tours.models.Person;
import ru.costa.tours.repositories.PassportRepository;
import ru.costa.tours.repositories.PersonRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;
    private final PassportRepository passportRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }
    public void addOrEdit(Person person) {
        personRepository.save(person);
        logger.info("Person successfully added: " + person);
    }
    public void delete(Person person) {
        personRepository.delete(person);
        logger.info("Person successfully deleted: " + person);
    }
    public Person findByLastName(String lastName) {
        return personRepository.findByLastName(lastName).orElse(null);
    }
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    public Person findByPhone(String phone) {
        return personRepository.findByPhone(phone).orElse(null);
    }
}
