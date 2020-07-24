package com.ironhack.loanservice.controller;

import com.ironhack.loanservice.model.Loan;
import com.ironhack.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    LoanService service;

    @GetMapping("/loans")
    public List<Loan> findAll() {
        return service.findAll();
    }

    @GetMapping("/loan/{id}")
    public Loan findById(@PathVariable(name = "id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/loan")
    public Loan save(@RequestBody Loan loan){
        return service.save(loan);
    }

    @PutMapping("/loan/{id}")
    public Loan change(@PathVariable(name = "id") Integer id, @RequestBody Loan loan) throws Exception {
        return service.change(id, loan);
    }


}
