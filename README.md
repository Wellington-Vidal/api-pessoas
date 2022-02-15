# api-pessoas
Api-pessoas (Projeto Digital Innovation One)

GET:
http://localhost:8080/api/v1/pessoa/
________________________________________________________

POST:
http://localhost:8080/api/v1/pessoa/

Ex (JSON): 

{
    "primeiroNome" : "Wellington",
    "ultimoNome" : "Vidal",
    "cpf" : "111.111.111-15",
    "dataNasc" : "10/06/1950",
    "telefones" : [
                    {"tipo" : "MOVEL", "numero" : "(81)91111-1111"}, 
                    {"tipo" : "RESIDENCIAL", "numero" : "(81)3011-1130"}
                  ]
}

________________________________________________________

PUT:
http://localhost:8080/api/v1/pessoa/6

Ex (JSON):

{
    "id": 6,
    "primeiroNome": "Klerys",
    "ultimoNome": "Vidal",
    "cpf": "111.111.111-13",
    "dataNasc": "10/06/1950",
    "telefones": [
        {
            "id": 5,
            "tipo": "MOVEL",
            "numero": "(81)91111-1111"
        },
        {
            "id": 6,
            "tipo": "RESIDENCIAL",
            "numero": "(81)3011-1130"
        }
    ]
}

________________________________________________________

DELETE:
http://localhost:8080/api/v1/pessoa/4
