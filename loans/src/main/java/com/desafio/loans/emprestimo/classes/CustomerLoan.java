package com.desafio.loans.emprestimo.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoan {
    @NotNull
    int age;
    @CPF
    @NotBlank
    String cpf;
    @NotBlank
    String name;
    @NotNull
    Double income;
    @NotBlank
    String location;

}
