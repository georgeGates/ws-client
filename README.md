# WS-CLIENT - API Microservice

Projet app Spring Boot com Docker compose & PostgreSQL

## 1. Executar docker-compose

`cd src/main/docker`

`docker-compose up`

## 2. Executar app ws-client

 1 - baixe a IDE Desenvolvimento STS https://spring.io/tools/sts/legacy;
 2 - baixe o projeto https://github.com/georgeGates/ws-client.git;
 3 - Abra a IDE  clicar com o direito Import->Maven->Existing Maven Project e importe o projeto  ws-client
 4- clicar com o direito em cima do projeto, selecionar Run As, depois Spring Boot App
 
 Para validação de requisição: POST, PUT, DELETE, GET, foi utilizado a Ferramentas para  modelagem   e documentação de APIs Rest - Swagger:
 http://localhost:8080/swagger-ui.html


 Para validação pelo Postman:

 POST: http://localhost:8080/api/client
 Document: 
 {
  "addressCep": "01001000",
  "addressNumber": 0,
  "birthDate": "2019-05-03",
  "cpf": "00000000000"
  "name": "Cliente"
 } 

 PUT: http://localhost:8080/api/client
 Document:
 {
  "addressCep": "01001000",
  "addressNumber": 30,
  "cpf": "00000000000",
  "birthDate": "2019-05-03",
  "id": 1,
  "name": "Cliente"
 }

 GET : http://localhost:8080/api/client/1
 observação: obter Cliente pelo ID

 GET: http://localhost:8080/api/client
 observação: listar Clientes

 DELETE: http://localhost:8080/api/client/1
 observação: deletar Cliente pelo ID

 



