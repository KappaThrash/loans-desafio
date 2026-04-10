package com.desafio.loans.emprestimo;

import com.desafio.loans.emprestimo.classes.CustomerLoan;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {
    LoanService Service;

    public LoanController(LoanService Service){
        this.Service = Service;
    }

    @PostMapping
    public ResponseEntity<?> postLoan(@RequestBody @Valid CustomerLoan loan){
        return Service.validateLoans(loan);
    }
}
