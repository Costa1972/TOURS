package ru.costa.tours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.costa.tours.models.Passport;

import java.util.Optional;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {
    Optional<Passport> findByNumber(String number);
}
