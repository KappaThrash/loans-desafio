package com.desafio.loans.emprestimo;

import com.desafio.loans.emprestimo.classes.CustomerLoan;
import com.desafio.loans.emprestimo.classes.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public ResponseEntity<Response> validateLoans(CustomerLoan loan){
        List<Loan> loansList  = new ArrayList<>();

        if( loan.getIncome() <= 3000){

        }



        return ResponseEntity.status(HttpStatus.OK).body(new Response(loan.getName(), loansList));
    }

}
