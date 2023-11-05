package com.cydeo.bootstrap;

import com.cydeo.entity.*;
import com.cydeo.enums.Status;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DataGenerator implements CommandLineRunner {


    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    PaymentRepository paymentRepository;
    MerchantRepository merchantRepository;
    CustomerRepository customerRepository;
    ItemRepository itemRepository;
    CartRepository cartRepository;




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

        Item item1 = new Item("Milk","M01");
        Item item2 = new Item("Sugar","M02");
        Item item3 = new Item("Bread","M03");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        //Assigned
        cart1.setItemList(Arrays.asList(item1,item2,item3));
        cart2.setItemList(Arrays.asList(item1,item2,item3));

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);



        merchantRepository.save(m1);
        paymentRepository.saveAll(paymentList);
    }
}

