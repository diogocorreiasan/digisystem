# digisystem

# Desafio I

Calcular
POST - http://localhost:8080/calculadora
{
	"acao" : "Soma",
	"numeros" : [4,2,3,4]
}

# Desafio II

Buscar Todos
GET - http://localhost:8080/pessoa

Buscar Por ID
GET - http://localhost:8080/pessoa/1

Buscar Por Nome
GET -http://localhost:8080/pessoa/nome/James

Buscar Por Salario
GET - http://localhost:8080/pessoa/salario/1000

Alterar
PUT - http://localhost:8080/pessoa/1
{
    "id": 1,
    "nome": "James Gosling",
    "idade": 55,
    "salario": 6000.00
}

Adicionar
POST - http://localhost:8080/pessoa
}
 "nome": "James Gosling",
    "idade": 55,
    "salario": 6000.00
}
