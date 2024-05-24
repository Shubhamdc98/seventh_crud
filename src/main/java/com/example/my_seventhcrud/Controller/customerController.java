package com.example.my_seventhcrud.Controller;

import com.example.my_seventhcrud.Service.CustomerService;
import com.example.my_seventhcrud.entity.Customer;
import com.example.my_seventhcrud.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class customerController {

    private final CustomerRepository customRepo;

    private final CustomerService customService;

    @PostMapping("/customer")
    private ResponseEntity<Customer> postCustomer(@RequestBody Customer cust){
        Customer ExistingCustomer = customService.postCustomer(cust);
        if(ExistingCustomer == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(cust);
        }
    }

    @GetMapping("/AllCustomer")
    private ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }

    @GetMapping("/customer/{id}")
    private ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer cust = customService.findCustomerById(id);
        if(cust == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cust);
    }



    @PutMapping("/updateCustomer/{id}")
    private ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer custo){
        Customer cust = customService.updateCustomer(id, custo);
        if(cust == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cust);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    private ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer cust = customService.deleteCustomer(id);
        if(cust == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(cust);
        }
    }
}
