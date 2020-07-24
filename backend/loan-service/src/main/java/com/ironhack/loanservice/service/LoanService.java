package com.ironhack.loanservice.service;

import com.ironhack.loanservice.model.Loan;
import com.ironhack.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepository repository;

    public List<Loan> findAll(){
        return repository.findAll();
    }

    public Loan findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(()->new Exception("No loan with that id"));
    }
    public Loan save(Loan loan){
        return repository.save(loan);
    }
    public Loan change(Integer id, Loan loan) throws Exception {
        Loan old = findById(id);
        loan.setId(old.getId());
        return repository.save(loan);
    }
}
