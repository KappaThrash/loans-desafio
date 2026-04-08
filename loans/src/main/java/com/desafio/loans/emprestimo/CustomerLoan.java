package com.desafio.loans.emprestimo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoan {
    @NotBlank
    int age;
    @CPF
    @NotBlank
    String cpf;
    String name;
    Double income;
    String location;

}
