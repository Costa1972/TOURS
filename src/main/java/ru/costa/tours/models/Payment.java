package ru.costa.tours.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "payment_id")
    private Long id;
    @Column(name = "amount")
    private double amount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_basis_id", referencedColumnName = "id")
    private PaymentBasis paymentBasis;
}
