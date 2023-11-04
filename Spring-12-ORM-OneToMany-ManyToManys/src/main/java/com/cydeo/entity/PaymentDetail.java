package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "payment_details")
@NoArgsConstructor
@Data
public class PaymentDetail extends BaseEntity{

    private int commissionAmount;
    private int merchantPayoutAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;


    @OneToOne(mappedBy = "paymentDetails")//has to match exactly the employees class Department object
    // without new populated column
    //with mappedBy = "exactly match whatever put EmployeeTable"
    private Payment payment;

    public PaymentDetail(int commissionAmount, int merchantPayoutAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;
    }
}
