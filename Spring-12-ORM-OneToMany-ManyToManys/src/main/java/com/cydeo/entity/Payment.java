package com.cydeo.entity;

import com.cydeo.enums.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@Data
public class Payment extends BaseEntity{


    private BigDecimal amount;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="payment_details")
    private PaymentDetail paymentDetails;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;
    public Payment(BigDecimal amount, LocalDate createdDate, Status status) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.status = status;
    }

}
