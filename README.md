# Empréstimos

Repo original: https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md

O desafio é implementar um serviço que determine quais modalidades de empréstimo uma pessoa tem acesso.

### Exemplo

As modalidades de empréstimo que serão analisadas são:

- **Empréstimo pessoal**: Taxa de juros de 4%.
- **Empréstimo consignado**: Taxa de juros de 2%.
- **Empréstimo com garantia**: Taxa de juros de 3%.

As modalidades de empréstimo disponíveis para uma pessoa são baseadas em algumas variáveis específicas, são elas:

- **Idade**
- **Salário**
- **Localização**

## Possibilidades

- Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo pessoal se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30
  anos e residir em São Paulo (SP).
- Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
- Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver
  menos de 30 anos e residir em São Paulo (SP).

O serviço recebe uma chamada para determinar quais modalidades de empréstimo uma pessoa tem acesso.

**[POST]** `{{host}}/customer-loans`

```json
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```

O serviço retorna uma resposta contendo o nome do cliente e uma lista de empréstimos aos quais ele tem acesso,
com os respectivos tipos e taxas de juros.

### Exemplos

```
Sucesso
HTTP/1.1 200 Ok
```

```json
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "PERSONAL",
            "interest_rate": 4
        },
        {
            "type": "GUARANTEED",
            "interest_rate": 3
        },
        {
            "type": "CONSIGNMENT",
            "interest_rate": 2
        }
    ]
}
```

```
Erro
HTTP/1.1 422 UNPROCESSABLE ENTITY
```
```json
{
    "timestamp": "2026-04-12T22:47:03.6986281-03:00",
    "status": 422,
    "error": "MethodArgumentNotValidException",
    "message": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<?> com.desafio.loans.emprestimo.loan.LoanController.postLoan(com.desafio.loans.emprestimo.classes.CustomerLoan): [Field error in object 'customerLoan' on field 'cpf': rejected value [25.484.389-23]; codes [CPF.customerLoan.cpf,CPF.cpf,CPF.java.lang.String,CPF]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customerLoan.cpf,cpf]; arguments []; default message [cpf]]; default message [número do registro de contribuinte individual brasileiro (CPF) inválido]] ",
    "path": "/customer-loans"
}
```
