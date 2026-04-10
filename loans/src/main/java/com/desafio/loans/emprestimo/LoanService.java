package com.desafio.loans.emprestimo;

import com.desafio.loans.emprestimo.classes.CustomerLoan;
import com.desafio.loans.emprestimo.classes.Response;
import com.desafio.loans.emprestimo.classes.loan.Loan;
import com.desafio.loans.emprestimo.classes.loan.LoanCONSIGNMENT;
import com.desafio.loans.emprestimo.classes.loan.LoanPERSONAL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public ResponseEntity<Response> validateLoans(CustomerLoan loan){
        List<Loan> loansList  = new ArrayList<>();
        double income = loan.getIncome();
        int age = loan.getAge();
        String local = loan.getLocation();

        // Emprestimo Pessoal
        if( loan.getIncome() <= 3000){
            loansList.add(new LoanPERSONAL());
        } else if(income > 3000 && income < 5000 && age < 30 && local.equals("SP")) {
            loansList.add(new LoanPERSONAL());
        }

        //Emprestimo Garantia
        if(income >= 5000){
            loansList.add(new LoanCONSIGNMENT());
        }

        //Emprestimo Consignado
        if(income <= 3000){
            loansList.add(new LoanCONSIGNMENT());
        } else if( income > 3000 && income < 5000 && age < 30 && local.equals("SP") ){

        }


        return ResponseEntity.status(HttpStatus.OK).body(new Response(loan.getName(), loansList));
    }

}
