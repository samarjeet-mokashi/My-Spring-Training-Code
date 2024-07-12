package com.boa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boa.entity.Payment;
import com.boa.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/Payments")
public class PaymentController {

    private final PaymentRepository PaymentRepository;

    @Autowired
    public PaymentController(PaymentRepository PaymentRepository) {
        this.PaymentRepository = PaymentRepository;
    }

    @GetMapping  // request mapping  change 
    public List<Payment> getAllPayments() {
        return PaymentRepository.findAll();
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment Payment) {
        return PaymentRepository.save(Payment);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return PaymentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        if (PaymentRepository.existsById(id)) {
            updatedPayment.setId(id);
            return PaymentRepository.save(updatedPayment);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        PaymentRepository.deleteById(id);
    }
}

