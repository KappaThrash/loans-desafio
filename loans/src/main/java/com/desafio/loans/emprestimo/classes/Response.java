package com.desafio.loans.emprestimo.classes;

import com.desafio.loans.emprestimo.classes.loan.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response {
    String customer;
    List<Loan> loans;
}
