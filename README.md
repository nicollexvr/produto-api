# Produto API — Atividade 7 (Desenvolvimento de APIs com Spring Boot)

API REST completa (CRUD) para gerenciar uma lista de produtos, com dados
armazenados em memória (sem banco de dados), seguindo o padrão MVC.

## Estrutura do projeto

```
src/main/java/com/exemplo/seuprojeto/
├── SeuprojetoApplication.java
├── model/
│   └── Produto.java
├── service/
│   └── ProdutoService.java
└── controller/
    └── ProdutoController.java
```

## Como rodar

1. Abra a pasta do projeto no VSCode (com extensão Java + Spring Boot Extension Pack).
2. Rode `SeuprojetoApplication.java` (ou `mvn spring-boot:run`).
3. A API sobe em `http://localhost:8080`.

## Roteiro de testes no Postman (o que a atividade pede para evidenciar)

1. **POST** `http://localhost:8080/produtos` — enviar 5 produtos (um de
   cada vez), com corpo JSON, por exemplo:
   ```json
   { "nome": "Teclado Mecânico", "preco": 250.90 }
   ```
2. **GET** `http://localhost:8080/produtos` — ver a lista completa com os
   5 produtos.
3. **GET** `http://localhost:8080/produtos/1` — buscar um produto
   específico por id.
4. **PUT** `http://localhost:8080/produtos/1`, `/3` e `/5` — atualizar
   3 produtos com novo JSON, por exemplo:
   ```json
   { "nome": "Teclado Mecânico RGB", "preco": 299.90 }
   ```
5. **DELETE** `http://localhost:8080/produtos/1` — deletar o produto de
   id 1.
6. **GET** `http://localhost:8080/produtos` — último GET, para confirmar
   que a deleção funcionou.

## Entrega (conforme pede o enunciado)

- Tirar print de cada uma das 4 operações testadas no Postman (POST, GET,
  PUT, DELETE) e colar num PDF.
- Escrever, no mesmo PDF, uma conclusão pessoal sobre o que você entendeu
  da atividade (essa parte é sua — precisa ser escrita com suas próprias
  palavras).
- Postar o PDF individualmente no Ulife, com o cabeçalho preenchido
  (data, nomes, RA, campus, período).
