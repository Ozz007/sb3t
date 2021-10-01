package com.app.sb3t.ws.controller;

import com.app.sb3t.business.domain.CustomerModel;
import com.app.sb3t.business.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCustomers(@RequestBody List<CustomerModel> customerList) {
        customerService.createCustomer(customerList);
        return ResponseEntity.ok()
                .body("OK");
    }

    @GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCustomers() {
        customerService.findCustomers();
        return ResponseEntity.ok()
                .body(customerService.findCustomers());
    }
}
