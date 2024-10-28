package ru.costa.tours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.costa.tours.models.PaymentBasis;

import java.util.Optional;

@Repository
public interface PaymentBasisRepository extends JpaRepository<PaymentBasis, Integer> {
    Optional<PaymentBasis> findByTitle(String title);
}
