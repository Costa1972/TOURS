package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "payments")
@Builder
@Data
@NoArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "payment_basis")
    Set<PaymentBasis> paymentBasisSet;

    public Payment(Long id, double amount, Set<PaymentBasis> paymentBasisSet) {
        this.id = id;
        this.amount = amount;
        this.paymentBasisSet = paymentBasisSet;
    }
}
