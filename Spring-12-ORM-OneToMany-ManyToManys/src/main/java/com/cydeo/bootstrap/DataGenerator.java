package com.cydeo.bootstrap;

import com.cydeo.entity.Customer;
import com.cydeo.entity.Merchant;
import com.cydeo.entity.Payment;
import com.cydeo.entity.PaymentDetail;
import com.cydeo.enums.Status;
import com.cydeo.repository.CustomerRepository;
import com.cydeo.repository.MerchantRepository;
import com.cydeo.repository.PaymentDetailRepository;
import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DataGenerator implements CommandLineRunner {


    PaymentRepository paymentRepository;
    MerchantRepository merchantRepository;
    CustomerRepository customerRepository;


    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args)throws Exception{
        List<Payment> paymentList = new ArrayList<>();


        Payment payment1 = new Payment(new BigDecimal("100.00"), LocalDate.of(2023, 11, 5), Status.SUCCESS);
        Payment payment2 = new Payment(new BigDecimal("500.00"), LocalDate.of(2023, 11, 6), Status.FAILURE);

        PaymentDetail paymentDetail1 = new PaymentDetail(10, 90, LocalDate.of(2023, 11, 7));
        PaymentDetail paymentDetail2 = new PaymentDetail(15, 85, LocalDate.of(2023, 11, 8));

        payment1.setPaymentDetails(paymentDetail1);
        payment2.setPaymentDetails(paymentDetail2);

        Merchant m1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.34"),3);

        Customer c1 = new Customer("EmreSmith","Mike","Smith","sds@mail.com","VA");

        payment1.setCustomer(c1);
        payment2.setCustomer(c1);

        customerRepository.save(c1);

       paymentList.addAll(Arrays.asList(payment1,payment2));

        payment1.setMerchant(m1);
        payment2.setMerchant(m1);
        merchantRepository.save(m1);
        paymentRepository.saveAll(paymentList);
    }
}

